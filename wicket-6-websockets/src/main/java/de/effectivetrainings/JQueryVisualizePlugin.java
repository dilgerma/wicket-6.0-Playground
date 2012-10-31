package de.effectivetrainings;

import org.apache.wicket.ajax.WicketEventJQueryResourceReference;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.JavaScriptUrlReferenceHeaderItem;
import org.apache.wicket.request.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author martindilger
 *         Date: 31.10.12
 *         Time: 15:06
 */
public class JQueryVisualizePlugin extends JavaScriptUrlReferenceHeaderItem {

    private static final String VISUALIZE_PLUGIN_URL = "https://raw.github.com/filamentgroup/jQuery-Visualize/master/js/visualize.jQuery.js";

    public JQueryVisualizePlugin() {
        super(VISUALIZE_PLUGIN_URL, "jquery-visualize", false, "utf-8","");
    }

    @Override
    public Iterable<?> getRenderTokens() {
        return Arrays.asList("jquery-visualize");
    }


    @Override
    public Iterable<? extends HeaderItem> getDependencies() {
        List<HeaderItem> deps = new ArrayList<HeaderItem>();
        deps.add(JavaScriptHeaderItem.forReference(WicketEventJQueryResourceReference.get()));
        return deps;
    }
}
