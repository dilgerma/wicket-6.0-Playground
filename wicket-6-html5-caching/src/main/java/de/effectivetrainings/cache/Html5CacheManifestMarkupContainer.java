package de.effectivetrainings.cache;

import org.apache.wicket.IResourceListener;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.TransparentWebMarkupContainer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.ResourceReference;

/**
 * @author martindilger
 *         Date: 01.12.12
 *         Time: 17:30
 */
public class Html5CacheManifestMarkupContainer<T> extends TransparentWebMarkupContainer implements IResourceListener {


    private ResourceReference resource;

    private IModel<? extends CacheManifest> cacheManifestModel;

    public Html5CacheManifestMarkupContainer(String id, IModel<CacheManifest> cacheManifestModel) {
        super(id);
        this.cacheManifestModel = cacheManifestModel;
    }

    public Html5CacheManifestMarkupContainer(String id, IModel<T> model, IModel<? extends CacheManifest> cacheManifestModel){
        super(id);
        setDefaultModel(model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        final Html5CacheResource cacheResource = new Html5CacheResource(getPage().getClass(), getLocale(),getStyle(),getVariation()){
            @Override
            protected String generateManifest(String template) {
                return cacheManifestModel.getObject().get(template);
            }
        };
        resource = new ResourceReference(getPage().getClass().getSimpleName() + ".manifest"){

            @Override
            public IResource getResource() {
                return cacheResource;
            }
        };

    }

    @Override
    protected void onConfigure() {
        super.onConfigure();
        add(AttributeAppender.append("manifest",urlFor(resource, getPage().getPageParameters()).toString()));
    }

    @Override
    public void onResourceRequested() {
        resource.getResource().respond(new IResource.Attributes(getRequest(),getResponse(),getPage().getPageParameters()));
    }
}
