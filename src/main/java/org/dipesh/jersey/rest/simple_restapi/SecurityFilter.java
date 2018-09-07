package org.dipesh.jersey.rest.simple_restapi;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;
import org.glassfish.jersey.internal.util.Base64;


@Provider
public class SecurityFilter implements ContainerRequestFilter {
	
	static Logger log = Logger.getLogger(SecurityFilter.class.getName());

	private static final String AUTHORIZATION_HEADER = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
	private static final String SECURE_URL_PREFIX = "secured";

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		if (requestContext.getUriInfo().getPath().contains(SECURE_URL_PREFIX)) {
			final List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER);
			if (authHeader != null && authHeader.size() > 0) {

				String authToken = authHeader.get(0);
				log.info("Auth token = " + authToken);
				authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
				final String decodedString = Base64.decodeAsString(authToken);
				final StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
				log.info("decoded string = " + decodedString);
				final String username = tokenizer.nextToken();
				log.info("User name = " + username);
				final String password = tokenizer.nextToken();
				log.info("Password = " + password);

				// Validate the user name and password here  -  This is a dummy autherization
				if ("admin".equals(username) && "password".equals(password)) {
					return;
				}

			}
			final Response authStatus = Response.status(Response.Status.UNAUTHORIZED)
					.entity("User is not allowed to access the resource").build();
			requestContext.abortWith(authStatus);
		}

	}

}
