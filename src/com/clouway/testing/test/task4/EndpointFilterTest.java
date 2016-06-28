package com.clouway.testing.test.task4;


import com.clouway.testing.task4.Endpoint;
import com.clouway.testing.task4.EndpointFilter;
import com.clouway.testing.task4.StartsWithKeyWord;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EndpointFilterTest {
    @Rule public JUnitRuleMockery context = new JUnitRuleMockery();
    Endpoint endpoint = context.mock(Endpoint.class);

    /**
     * Mocks Endpoint, the test returns True, also checks for invocation
     */

    @Test
    public void filterEndpointTrue(){
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
    public void filterEndpointFalse(){
        EndpointFilter endpointFilter = new EndpointFilter(endpoint);
        context.checking(new Expectations(){{
            oneOf(endpoint).matches("user");
            will(returnValue(false));
        }});
        assertFalse(endpointFilter.shouldFilter("user"));
    }

    /**
     * Adds Endpoint and StartsWithKeyWord objects to the EndpointFilter and checks if
     * matches() methods (in StartsWithKeyWord class and Endpoint interface) are invoked
     * and shouldFilter() method returns True with correct keyWord.
     */

    @Test
    public void filterAddressWithKeyWordReturnsTrue(){ //Happy path
        final String keyWord = "/user";
        StartsWithKeyWord urls = new StartsWithKeyWord("/user/Pictures");
        EndpointFilter endpointFilter = new EndpointFilter(endpoint,urls);
        context.checking(new Expectations(){{
            oneOf(endpoint).matches(keyWord);
            will(returnValue(true));
        }});
        assertTrue(endpointFilter.shouldFilter(keyWord));
    }

    /**
     * Adds Endpoint and StartsWithKeyWord objects to the EndpointFilter and checks if
     * matches() methods (in StartsWithKeyWord class and Endpoint interface) are invoked
     * and shouldFilter() method returns False without the correct keyWord.
     */

    @Test
    public void filterAddressWithKeyWordReturnsFalse(){
        final String keyWord = "/user";
        StartsWithKeyWord urls = new StartsWithKeyWord("/guest/Pictures");
        EndpointFilter endpointFilter = new EndpointFilter(endpoint,urls);
        context.checking(new Expectations(){{
            oneOf(endpoint).matches(keyWord);
            will(returnValue(false));
        }});
        assertFalse(endpointFilter.shouldFilter(keyWord));
    }
}
