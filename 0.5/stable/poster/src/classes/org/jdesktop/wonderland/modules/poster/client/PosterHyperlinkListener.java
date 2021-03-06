/**
 * Copyright (c) 2016, Envisiture Consulting, LLC, All Rights Reserved
 */
/**
 * Open Wonderland
 *
 * Copyright (c) 2011, Open Wonderland Foundation, All Rights Reserved
 *
 * Redistributions in source code form must reproduce the above
 * copyright and this condition.
 *
 * The contents of this file are subject to the GNU General Public
 * License, Version 2 (the "License"); you may not use this file
 * except in compliance with the License. A copy of the License is
 * available at http://www.opensource.org/licenses/gpl-license.php.
 *
 * The Open Wonderland Foundation designates this particular file as
 * subject to the "Classpath" exception as provided by the Open Wonderland
 * Foundation in the License file that accompanied this code.
 */
package org.jdesktop.wonderland.modules.poster.client;

import com.jme.math.FastMath;
import com.jme.math.Quaternion;
import com.jme.math.Vector3f;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Window;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.SwingUtilities;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import org.jdesktop.wonderland.client.cell.Cell;
import org.jdesktop.wonderland.client.help.WebBrowserLauncher;
import org.jdesktop.wonderland.client.input.InputManager;
import org.jdesktop.wonderland.client.jme.ClientContextJME;
import org.jdesktop.wonderland.client.jme.MainFrame.PlacemarkType;
import org.jdesktop.wonderland.client.login.LoginManager;
import org.jdesktop.wonderland.common.cell.CellTransform;
import org.jdesktop.wonderland.modules.placemarks.api.client.PlacemarkRegistry;
import org.jdesktop.wonderland.modules.placemarks.api.client.PlacemarkRegistryFactory;
import org.jdesktop.wonderland.modules.placemarks.api.common.Placemark;
import org.jdesktop.wonderland.modules.poster.common.CoverScreenData;

/**
 * Handle hyperlinks in a poster
 *
 * @author Jonathan Kaplan <jonathankap@gmail.com>
 * @author Abhishek Upadhyay <abhiit61@gmail.com>
 */
public class PosterHyperlinkListener implements HyperlinkListener {

    private static final Logger LOGGER
            = Logger.getLogger(PosterHyperlinkListener.class.getName());

    private final JEditorPane panel;
    private final Cell cell;
    private boolean cursorSet;
    private HashSet<Element> highlightedElements = null;

    public PosterHyperlinkListener(JEditorPane panel, Cell cell) {
        this.panel = panel;
        this.cell = cell;
    }

    private void changeColor(Element el, Color color) {
        HTMLDocument doc = (HTMLDocument) panel.getDocument();
        int start = el.getStartOffset();
        int end = el.getEndOffset();
        StyleContext ss = doc.getStyleSheet();
        Style style = ss.getStyle("HighlightedHyperlink");
        if (style == null) {
            style = ss.addStyle("HighlightedHyperlink", null);
        }
        style.addAttribute(StyleConstants.Foreground, color);
        doc.setCharacterAttributes(start, end - start, style, false);

    }

    public static Color stringToColor(final String value) {
        if (value == null) {
            return Color.black;
        }
        try {
            // get color by hex or octal value
            return Color.decode(value);
        } catch (NumberFormatException nfe) {
            // if we can't decode lets try to get it by name
            try {
                // try to get a color by name using reflection
                final Field f = Color.class.getField(value);
                return (Color) f.get(null);
            } catch (Exception ce) {
                // if we can't get any color return black
                return Color.black;
            }
        }
    }

    private Color getSpecificColor(Element el, boolean hColor) {
        Color color = Color.black;
        if (hColor) {
            color = Color.YELLOW;
        }
        AttributeSet as = el.getAttributes();
        SimpleAttributeSet value = (SimpleAttributeSet) as.getAttribute(HTML.Tag.A);
        if (value != null) {
            Object colorObj = value.getAttribute(HTML.Attribute.COLOR);
            if (colorObj != null) {
                String[] colors = colorObj.toString().split("\\|");
                if (hColor) {
                    if (colors.length > 1) {
                        color = stringToColor(colors[1]);
                    }
                } else {
                    color = stringToColor(colors[0]);
                }
            }
        }
        return color;
    }

    public void hyperlinkUpdate(HyperlinkEvent e) {
        if (e.getEventType() == HyperlinkEvent.EventType.ENTERED) {
            setCursor(true);

            changeColor(e.getSourceElement(), getSpecificColor(e.getSourceElement(), true));
            if (highlightedElements == null) {
                highlightedElements = new HashSet<Element>();
            }
            for (Element el : highlightedElements) {
                changeColor(el, getSpecificColor(el, false));
            }
            highlightedElements.add(e.getSourceElement());
            return;
        } else if (e.getEventType() == HyperlinkEvent.EventType.EXITED) {
            setCursor(false);
            changeColor(e.getSourceElement(), getSpecificColor(e.getSourceElement(), false));
            highlightedElements.remove(e.getSourceElement());
            return;
        } else if (e.getDescription() == null) {
            return;
        }

        if (!InputManager.isAnyKeyPressed()) {
            try {
                handleURI(new URI(e.getDescription()));
            } catch (URISyntaxException use) {
                LOGGER.log(Level.WARNING, "Error parsing " + e.getDescription(),
                        use);
            }
        }
    }

    protected void setCursor(boolean link) {
        if (this.cursorSet == link) {
            return;
        }

        this.cursorSet = link;

        Window w = SwingUtilities.windowForComponent(panel);
        if (link) {
            w.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        } else {
            w.setCursor(Cursor.getDefaultCursor());
        }
    }

    protected void handleURI(URI u) {
        String scheme = u.getScheme();
        if (scheme != null && !scheme.equalsIgnoreCase("wlserver")) {
            handleWebURI(u);
            return;
        }

        // start with the poster's current location
        CellTransform start = cell.getWorldTransform();

        String server = u.getHost();
        Vector3f loc = start.getTranslation(null);
        Quaternion look = start.getRotation(null);

        CoverScreenData csd = new CoverScreenData();
        Placemark placemarkObj = null;

        Map<String, String> parsed = parseQuery(u.getRawQuery());

        // see if there is a placemark specified
        String placemark = parsed.get("placemark");
        if (placemark != null) {

            PlacemarkRegistry pr = PlacemarkRegistryFactory.getInstance();
            Set<Placemark> placemarks = 
                    pr.getAllPlacemarks(PlacemarkType.SYSTEM);
            for (Placemark p : placemarks) {
                if (p.getName().equals(placemark)) {
                    loc.setX(p.getX());
                    loc.setY(p.getY());
                    loc.setZ(p.getZ());
                    look.fromAngles(0, p.getAngle() * FastMath.DEG_TO_RAD, 0);
                    server = p.getUrl();
                    csd.setBackgroundColor(p.getBackgroundColor());
                    csd.setTextColor(p.getTextColor());
                    csd.setMessage(p.getMessage());
                    csd.setImageURL(p.getImageURL());
                    placemarkObj = p;
                    break;
                }
            }
        }

        // search for individual x, y and z properties
        String x = parsed.get("x");
        String y = parsed.get("y");
        String z = parsed.get("z");

        // look for a single combined location property
        String locStr = parsed.get("location");
        if (locStr != null) {
            String[] comp = locStr.split("\\s+");
            if (comp.length == 3) {
                x = comp[0];
                y = comp[1];
                z = comp[2];
            }
        }

        // set x, y and z
        RelativeFloat relX = null;
        RelativeFloat relY = null;
        RelativeFloat relZ = null;

        Vector3f relOffset = new Vector3f();

        if (x != null) {
            relX = RelativeFloat.parse(x);

            if (relX.relative) {
                relOffset.setX(relX.value);
            } else {
                loc.setX(relX.value);
            }
        }

        if (y != null) {
            relY = RelativeFloat.parse(y);

            if (relY.relative) {
                relOffset.setY(relY.value);
            } else {
                loc.setY(relY.value);
            }
        }

        if (z != null) {
            relZ = RelativeFloat.parse(z);

            if (relZ.relative) {
                relOffset.setZ(relZ.value);
            } else {
                loc.setZ(relZ.value);
            }
        }

        // if ther relative offset is non-zero, rotate it based on the
        // look direction of the poster, and then apply it
        if (!relOffset.equals(Vector3f.ZERO)) {
            relOffset = look.mult(relOffset);
            loc.addLocal(relOffset);
        }

        //cell status change listener for removing cover screen
        new CoverScreenListener(placemarkObj, LoginManager.getPrimary(), loc, "change", csd);

        // set the angle from a look property
        String angle = parsed.get("look");
        if (angle != null) {
            float[] angles = look.toAngles(null);
            float angDeg = angles[1] * FastMath.RAD_TO_DEG;
            angDeg = RelativeFloat.parse(angle).apply(angDeg);
            look.fromAngles(angles[0], angDeg * FastMath.DEG_TO_RAD, angles[2]);
        }

        try {
            ClientContextJME.getClientMain().gotoLocation(server, loc, look);
        } catch (IOException ex) {
            LOGGER.log(Level.WARNING, "Error connecting to " + server, ex);
        }
    }

    private Map<String, String> parseQuery(String rawQuery) {
        Map<String, String> out = new LinkedHashMap<String, String>();
        if (rawQuery == null) {
            return out;
        }

        for (String pair : rawQuery.split("&")) {
            String[] split = pair.split("=");
            if (split.length == 1) {
                out.put(split[0], null);
            } else if (split.length >= 2) {
                try {
                    out.put(split[0], URLDecoder.decode(split[1], "UTF-8"));
                } catch (UnsupportedEncodingException ex) {
                    LOGGER.log(Level.WARNING, "Unable to decode " + split[1], ex);
                }
            }
        }

        return out;
    }

    protected void handleWebURI(URI u) {
        try {
            WebBrowserLauncher.openURL(u.toASCIIString());
        } catch (Exception ex) {
            LOGGER.log(Level.WARNING, "Unable to open browser for " + 
                       u, ex);
        }
    }

    private static class RelativeFloat {

        private final float value;
        private final boolean relative;

        RelativeFloat(float value, boolean relative) {
            this.value = value;
            this.relative = relative;
        }

        float apply(float current) {
            if (relative) {
                return current + value;
            } else {
                return value;
            }
        }

        public static RelativeFloat parse(String str) {
            boolean relative = false;

            if (str.startsWith("@")) {
                relative = true;
                str = str.substring(1);
            }

            return new RelativeFloat(Float.parseFloat(str), relative);
        }
    }
}
