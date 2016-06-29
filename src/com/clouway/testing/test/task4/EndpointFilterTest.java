package com.clouway.testing.test.task4;


import com.clouway.testing.task4.Endpoint;
import com.clouway.testing.task4.EndpointFilter;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EndpointFilterTest {
    @Rule public JUnitRuleMockery context = new JUnitRuleMockery();
    private Endpoint endpoint = context.mock(Endpoint.class);

    /**
     * Mocks Endpoint, the test returns True, also checks for invocation
     */

    @Test
    public void endpointFilterReturnsTrue(){
        EndpointFilter endpointFilter = new EndpointFilter(endpoint);
        context.checking(new Expectations(){{
            oneOf(endpoint).matches("user");
            will(returnValue(true));
        }});
        assertTrue(endpointFilter.shouldFilter("user"));
    }

    /**
     * Mocks Endpoint, the test returns False
     */

    @Test
    public void endpointFilterReturnsFalse(){
        EndpointFilter endpointFilter = new EndpointFilter(endpoint);
        context.checking(new Expectations(){{
            oneOf(endpoint).matches("user");
            will(returnValue(false));
        }});
        assertFalse(endpointFilter.shouldFilter("user"));
    }

    /**
     * Mocks several Endpoints, all of them Fail
     */

    @Test
    public void allEndpointsAreNotMatching(){
        Endpoint endpoint0 = context.mock(Endpoint.class, "mock0");
        Endpoint endpoint1 = context.mock(Endpoint.class, "mock1");
        Endpoint endpoint2 = context.mock(Endpoint.class, "mock2");
        EndpointFilter endpointFilter = new EndpointFilter(endpoint0,endpoint1,endpoint2);
        context.checking(new Expectations() {{
            oneOf(endpoint0).matches("/user");
            will(returnValue(false));

            oneOf(endpoint1).matches("/user");
            will(returnValue(false));

            oneOf(endpoint2).matches("/user");
            will(returnValue(false));
        }});
        assertFalse(endpointFilter.shouldFilter("/user"));
    }

    /**
     * Mocks several Endpoints, at least one of them must be True
     */

    @Test
    public void filterSeveralEndpointsTheLastOneWillMatch(){
        Endpoint endpoint0 = context.mock(Endpoint.class, "mock0");
        Endpoint endpoint1 = context.mock(Endpoint.class, "mock1");
        Endpoint endpoint2 = context.mock(Endpoint.class, "mock2");
        EndpointFilter endpointFilter = new EndpointFilter(endpoint0,endpoint1,endpoint2);
        context.checking(new Expectations() {{
            oneOf(endpoint0).matches("/user");
            will(returnValue(false));

            oneOf(endpoint1).matches("/user");
            will(returnValue(false));

            oneOf(endpoint2).matches("/user");
            will(returnValue(true));
        }});
        assertTrue(endpointFilter.shouldFilter("/user"));
    }
}
