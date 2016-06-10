package com.vaadin.demo.dashboard.view.carousel;

import com.vaadin.demo.dashboard.DashboardUI;
import com.vaadin.demo.dashboard.domain.PxPhoto;
import com.vaadin.demo.dashboard.event.DashboardEventBus;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Responsive;
import com.vaadin.ui.Component;
import com.vaadin.ui.Image;
import com.vaadin.ui.VerticalLayout;

import org.vaadin.virkki.carousel.ComponentSelectListener;
import org.vaadin.virkki.carousel.HorizontalCarousel;
import org.vaadin.virkki.carousel.client.widget.gwt.ArrowKeysMode;
import org.vaadin.virkki.carousel.client.widget.gwt.CarouselLoadMode;

/**
 * Created by Zeynin on 2016-05-30.
 */

@SuppressWarnings("serial")
public final class CarouselView extends VerticalLayout implements View, ComponentSelectListener
{
    private HorizontalCarousel carousel = new HorizontalCarousel();

    public CarouselView()
    {
        setSizeFull();
        addStyleName("carousel");
        DashboardEventBus.register(this);
        Responsive.makeResponsive(this);

        // addComponent carousel here

        carousel.setSizeFull();

        // Only react to arrow keys when focused
        carousel.setArrowKeysMode( ArrowKeysMode.FOCUS);
        carousel.setLoadMode( CarouselLoadMode.SMART);
        carousel.setTransitionDuration(2000);
        carousel.setButtonsVisible( false );
        carousel.addComponentSelectListener( this );

        for (final PxPhoto photo : DashboardUI.getDataProvider().getPhotos())
        {
            Image photoFeed = new Image(null, new ExternalResource(
                    photo.getImageUrl() ) );
            photoFeed.setSizeFull();
            carousel.addComponent(photoFeed);
        }

        // start off the auto-scroll
        carousel.scroll( -1 );

        // Add the Carousel to a parent layout
        addComponent(carousel);
    }


    @Override
    public void enter( ViewChangeListener.ViewChangeEvent viewChangeEvent )
    {

    }

    @Override
    public void componentSelected( Component component )
    {
        carousel.scroll( -1 );
    }
}
