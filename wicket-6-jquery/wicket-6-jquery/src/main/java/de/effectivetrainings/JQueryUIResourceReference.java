package de.effectivetrainings;

import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.JavaScriptUrlReferenceHeaderItem;
import org.apache.wicket.resource.JQueryResourceReference;
import org.apache.wicket.settings.def.JavaScriptLibrarySettings;

import java.util.ArrayList;
import java.util.List;


/**
 * @author martindilger
 *         Date: 27.10.12
 *         Time: 14:05
 */
public class JQueryUIResourceReference extends JavaScriptUrlReferenceHeaderItem {

    private static final String URL= "http://code.jquery.com/ui/1.9.1/jquery-ui.js";

    public JQueryUIResourceReference() {
        super(URL, "jquery-ui-1.9.1", true, "utf-8", "");
    }

    /**
     * jedesmal wenn die jquery-ui resource reference gerendert wird muss auch
     * die jquery-bibliothek gerendert werden.
     * @return
     */
    @Override
    public Iterable<? extends HeaderItem> getDependencies() {
        List<HeaderItem> deps = new ArrayList<HeaderItem>();
        deps.add(JavaScriptHeaderItem.forReference(JQueryResourceReference.get()));
        return deps;
    }
}
