package com.vaadin.demo.dashboard.view.carousel;

import com.google.gson.JsonObject;
import com.vaadin.demo.dashboard.event.DashboardEventBus;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Image;
import com.vaadin.ui.VerticalLayout;

import org.vaadin.virkki.carousel.HorizontalCarousel;
import org.vaadin.virkki.carousel.client.widget.gwt.ArrowKeysMode;
import org.vaadin.virkki.carousel.client.widget.gwt.CarouselLoadMode;

/**
 * Created by Zeynin on 2016-05-30.
 */

@SuppressWarnings("serial")
public final class CarouselView extends VerticalLayout implements View
{
    JsonObject json;

    public CarouselView() {
        //setSizeFull();
        addStyleName("carousel");
        DashboardEventBus.register(this);

        // addComponent carousel here
        final HorizontalCarousel carousel = new HorizontalCarousel();

        //carousel.setWidth("100%");
        //carousel.setHeight("100%");

        // Only react to arrow keys when focused
        carousel.setArrowKeysMode( ArrowKeysMode.FOCUS);
        // Fetch children smart
        carousel.setLoadMode( CarouselLoadMode.SMART);
        // Transition animations between the children run 500 milliseconds
        carousel.setTransitionDuration(500);
        //carousel.addComponentSelectListener( e -> {
        //    this.setData(new BeanItemContainer<>(Customer.class,
        //            service.findAll(e.getText())) );

        // Add the child Components
        //carousel.addComponent(new Button("First child"));
        //carousel.addComponent(new Label("Second child"));
        //carousel.addComponent(new TextField("Third child"));

        //width=\"240\" height=\"180\"
        Image photo = new Image( "Sydney Harbor from Ferry", new ExternalResource(
                "https://farm8.staticflickr.com/7340/26779799504_73d2fbfff0_m.jpg" ) );
        //photo.setWidth(240.0f, Unit.PIXELS);
        //photo.setHeight(180.0f, Unit.PIXELS);
        carousel.addComponent(photo);

        Image photo1 = new Image( "S574e49e36a9c4", new ExternalResource(
                "https://farm8.staticflickr.com/7189/26779802774_df4f479376_m.jpg" ) );

        //photo1.setWidth(240.0f, Unit.PIXELS);
        //photo1.setHeight(180.0f, Unit.PIXELS);
        carousel.addComponent(photo1);

        Image photo2 = new Image( "Lawrason\\'s Snowflake and Flusho sign (2)", new ExternalResource(
                "https://farm8.staticflickr.com/7239/26779801484_50c0ac3e6d_m.jpg" ) );
        //photo2.setWidth(240.0f, Unit.PIXELS);
        //photo2.setHeight(180.0f, Unit.PIXELS);
        carousel.addComponent(photo2);

        // Add the Carousel to a parent layout
        addComponent(carousel);
    }

/*
    private ComponentSelectListener loadPhotos()
    {

        return;
    }
*/

    @Override
    public void enter( ViewChangeListener.ViewChangeEvent viewChangeEvent )
    {

    }

}
