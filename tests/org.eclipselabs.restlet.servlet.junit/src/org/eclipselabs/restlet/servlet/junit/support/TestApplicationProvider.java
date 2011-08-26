/*******************************************************************************
 * Copyright (c) 2011.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     - initial API and implementation
 *******************************************************************************/

package org.eclipselabs.restlet.servlet.junit.support;

import javax.servlet.ServletContext;

import org.eclipselabs.restlet.ApplicationProvider;
import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Context;
import org.restlet.data.Protocol;

/**
 * @author bhunt
 * 
 */
public class TestApplicationProvider extends ApplicationProvider
{
	@Override
	public String getAlias()
	{
		return "/";
	}

	@Override
	public Application createApplication(Context context)
	{
		ServletContext servletContext = (ServletContext) context.getAttributes().get(SERVLET_CONTEXT_ATTRIBUTE);
		Component component = (Component) servletContext.getAttribute(COMPONENT_ATTRIBUTE);
		component.getClients().add(Protocol.FILE);
		return super.createApplication(context);
	}
}
