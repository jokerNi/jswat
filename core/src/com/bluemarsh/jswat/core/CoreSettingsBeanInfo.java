/*
 *                     Sun Public License Notice.
 *
 * The contents of this file are subject to the Sun Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. A copy of the License is available at
 * http://www.sun.com/
 *
 * The Original Code is the JSwat Core module. The Initial Developer of the
 * Original Code is Nathan L. Fiedler. Portions created by Nathan L. Fiedler
 * are Copyright (C) 2005. All Rights Reserved.
 *
 * Contributor(s): Nathan L. Fiedler.
 *
 * $Id: CoreSettingsBeanInfo.java 15 2007-06-03 00:01:17Z nfiedler $
 */

package com.bluemarsh.jswat.core;

import java.beans.BeanDescriptor;
import java.beans.EventSetDescriptor;
import java.beans.IntrospectionException;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;
import org.openide.util.NbBundle;

/**
 * Provides JavaBeans information for the CoreSettings class.
 *
 * @author Nathan Fiedler
 */
public class CoreSettingsBeanInfo extends SimpleBeanInfo {
    
    // Bean descriptor information will be obtained from introspection.//GEN-FIRST:BeanDescriptor
    private static BeanDescriptor beanDescriptor = null;
    private static BeanDescriptor getBdescriptor(){
//GEN-HEADEREND:BeanDescriptor
        
        // Here you can add code for customizing the BeanDescriptor.
        
        return beanDescriptor;     }//GEN-LAST:BeanDescriptor
    
    
    // Properties information will be obtained from introspection.//GEN-FIRST:Properties
    private static PropertyDescriptor[] properties = null;
    private static PropertyDescriptor[] getPdescriptor(){
//GEN-HEADEREND:Properties
        try {
            properties = new PropertyDescriptor[] {
                new PropertyDescriptor("connectionTimeout", CoreSettings.class),
                new PropertyDescriptor("invocationTimeout", CoreSettings.class),
                new PropertyDescriptor("showAllThreads", CoreSettings.class),
                new PropertyDescriptor("showHiddenFiles", CoreSettings.class),
                new PropertyDescriptor("skipSynthetics", CoreSettings.class),
                new PropertyDescriptor("sourceExtension", CoreSettings.class),
                new PropertyDescriptor("steppingExcludes", CoreSettings.class),
            };

            properties[0].setDisplayName(NbBundle.getMessage(CoreSettings.class,
                    "PROP_ConnectionTimeout"));
            properties[0].setShortDescription(NbBundle.getMessage(CoreSettings.class,
                    "HINT_ConnectionTimeout"));

            properties[1].setDisplayName(NbBundle.getMessage(CoreSettings.class,
                    "PROP_InvocationTimeout"));
            properties[1].setShortDescription(NbBundle.getMessage(CoreSettings.class,
                    "HINT_InvocationTimeout"));

            properties[2].setDisplayName(NbBundle.getMessage(CoreSettings.class,
                    "PROP_ShowAllThreads"));
            properties[2].setShortDescription(NbBundle.getMessage(CoreSettings.class,
                    "HINT_ShowAllThreads"));

            properties[3].setDisplayName(NbBundle.getMessage(CoreSettings.class,
                    "PROP_ShowHiddenFiles"));
            properties[3].setShortDescription(NbBundle.getMessage(CoreSettings.class,
                    "HINT_ShowHiddenFiles"));

            properties[4].setDisplayName(NbBundle.getMessage(CoreSettings.class,
                    "PROP_SkipSynthetics"));
            properties[4].setShortDescription(NbBundle.getMessage(CoreSettings.class,
                    "HINT_SkipSynthetics"));

            properties[5].setDisplayName(NbBundle.getMessage(CoreSettings.class,
                    "PROP_SourceExtension"));
            properties[5].setShortDescription(NbBundle.getMessage(CoreSettings.class,
                    "HINT_SourceExtension"));

            properties[6].setDisplayName(NbBundle.getMessage(CoreSettings.class,
                    "PROP_SteppingExcludes"));
            properties[6].setShortDescription(NbBundle.getMessage(CoreSettings.class,
                    "HINT_SteppingExcludes"));
            properties[6].setPropertyEditorClass(SteppingExcludesEditor.class);
            properties[6].setValue("canEditAsText", Boolean.FALSE);
        } catch (IntrospectionException ie) {
            return null;
        }
        return properties;     }//GEN-LAST:Properties
    
    // Event set information will be obtained from introspection.//GEN-FIRST:Events
    private static EventSetDescriptor[] eventSets = null;
    private static EventSetDescriptor[] getEdescriptor(){
//GEN-HEADEREND:Events
        
        // Here you can add code for customizing the event sets array.
        
        return eventSets;     }//GEN-LAST:Events
    
    // Method information will be obtained from introspection.//GEN-FIRST:Methods
    private static MethodDescriptor[] methods = null;
    private static MethodDescriptor[] getMdescriptor(){
//GEN-HEADEREND:Methods
        
        // Here you can add code for customizing the methods array.
        
        return methods;     }//GEN-LAST:Methods
    
    private static java.awt.Image iconColor16 = null;//GEN-BEGIN:IconsDef
    private static java.awt.Image iconColor32 = null;
    private static java.awt.Image iconMono16 = null;
    private static java.awt.Image iconMono32 = null;//GEN-END:IconsDef
    private static String iconNameC16 = null;//GEN-BEGIN:Icons
    private static String iconNameC32 = null;
    private static String iconNameM16 = null;
    private static String iconNameM32 = null;//GEN-END:Icons
    
    private static int defaultPropertyIndex = -1;//GEN-BEGIN:Idx
    private static int defaultEventIndex = -1;//GEN-END:Idx
    
    
//GEN-FIRST:Superclass
    
    // Here you can add code for customizing the Superclass BeanInfo.
    
//GEN-LAST:Superclass
    
    /**
     * Gets the bean's <code>BeanDescriptor</code>s.
     *
     * @return BeanDescriptor describing the editable
     * properties of this bean.  May return null if the
     * information should be obtained by automatic analysis.
     */
    public BeanDescriptor getBeanDescriptor() {
        return getBdescriptor();
    }
    
    /**
     * Gets the bean's <code>PropertyDescriptor</code>s.
     *
     * @return An array of PropertyDescriptors describing the editable
     * properties supported by this bean.  May return null if the
     * information should be obtained by automatic analysis.
     * <p>
     * If a property is indexed, then its entry in the result array will
     * belong to the IndexedPropertyDescriptor subclass of PropertyDescriptor.
     * A client of getPropertyDescriptors can use "instanceof" to check
     * if a given PropertyDescriptor is an IndexedPropertyDescriptor.
     */
    public PropertyDescriptor[] getPropertyDescriptors() {
        return getPdescriptor();
    }
    
    /**
     * Gets the bean's <code>EventSetDescriptor</code>s.
     *
     * @return  An array of EventSetDescriptors describing the kinds of
     * events fired by this bean.  May return null if the information
     * should be obtained by automatic analysis.
     */
    public EventSetDescriptor[] getEventSetDescriptors() {
        return getEdescriptor();
    }
    
    /**
     * Gets the bean's <code>MethodDescriptor</code>s.
     *
     * @return  An array of MethodDescriptors describing the methods
     * implemented by this bean.  May return null if the information
     * should be obtained by automatic analysis.
     */
    public MethodDescriptor[] getMethodDescriptors() {
        return getMdescriptor();
    }
    
    /**
     * A bean may have a "default" property that is the property that will
     * mostly commonly be initially chosen for update by human's who are
     * customizing the bean.
     * @return  Index of default property in the PropertyDescriptor array
     * 		returned by getPropertyDescriptors.
     * <P>	Returns -1 if there is no default property.
     */
    public int getDefaultPropertyIndex() {
        return defaultPropertyIndex;
    }
    
    /**
     * A bean may have a "default" event that is the event that will
     * mostly commonly be used by human's when using the bean.
     * @return Index of default event in the EventSetDescriptor array
     *		returned by getEventSetDescriptors.
     * <P>	Returns -1 if there is no default event.
     */
    public int getDefaultEventIndex() {
        return defaultEventIndex;
    }
    
    /**
     * This method returns an image object that can be used to
     * represent the bean in toolboxes, toolbars, etc.   Icon images
     * will typically be GIFs, but may in future include other formats.
     * <p>
     * Beans aren't required to provide icons and may return null from
     * this method.
     * <p>
     * There are four possible flavors of icons (16x16 color,
     * 32x32 color, 16x16 mono, 32x32 mono).  If a bean choses to only
     * support a single icon we recommend supporting 16x16 color.
     * <p>
     * We recommend that icons have a "transparent" background
     * so they can be rendered onto an existing background.
     *
     * @param  iconKind  The kind of icon requested.  This should be
     *    one of the constant values ICON_COLOR_16x16, ICON_COLOR_32x32,
     *    ICON_MONO_16x16, or ICON_MONO_32x32.
     * @return  An image object representing the requested icon.  May
     *    return null if no suitable icon is available.
     */
    public java.awt.Image getIcon(int iconKind) {
        switch ( iconKind ) {
            case ICON_COLOR_16x16:
                if ( iconNameC16 == null )
                    return null;
                else {
                    if( iconColor16 == null )
                        iconColor16 = loadImage( iconNameC16 );
                    return iconColor16;
                }
            case ICON_COLOR_32x32:
                if ( iconNameC32 == null )
                    return null;
                else {
                    if( iconColor32 == null )
                        iconColor32 = loadImage( iconNameC32 );
                    return iconColor32;
                }
            case ICON_MONO_16x16:
                if ( iconNameM16 == null )
                    return null;
                else {
                    if( iconMono16 == null )
                        iconMono16 = loadImage( iconNameM16 );
                    return iconMono16;
                }
            case ICON_MONO_32x32:
                if ( iconNameM32 == null )
                    return null;
                else {
                    if( iconMono32 == null )
                        iconMono32 = loadImage( iconNameM32 );
                    return iconMono32;
                }
            default: return null;
        }
    }
}