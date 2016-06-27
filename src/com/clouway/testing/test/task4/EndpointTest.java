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

public class EndpointTest {
    @Rule public JUnitRuleMockery context = new JUnitRuleMockery();

    /**
     * Mocks Endpoint, the test returns True
     */

    @Test
    public void filterEndpointTrue(){
        Endpoint endpoint = context.mock(Endpoint.class);
        EndpointFilter endpointFilter = new EndpointFilter(endpoint);
        context.checking(new Expectations(){{
            oneOf(endpoint).matches("user");
            will(returnValue(true));
        }});
        endpointFilter.shouldFilter("user");
    }

    /**
     * Mocks Endpoint, the test returns False
     */

    @Test
    public void filterEndpointFalse(){
        Endpoint endpoint = context.mock(Endpoint.class);
        EndpointFilter endpointFilter = new EndpointFilter(endpoint);
        context.checking(new Expectations(){{
            oneOf(endpoint).matches("user");
            will(returnValue(false));
        }});
        endpointFilter.shouldFilter("user");
    }

    /**
     * Adds StartsWithKeyWord array to the EndpointFilter and checks if
     * matches() method (in StartsWithKeyWord class) is invoked
     * and shouldFilter() method returns True whit correct keyWord.
     */

    @Test
    public void filterAddressWithKeyWordReturnsTrue(){ //Happy path
        final String keyWord = "/user";
        StartsWithKeyWord urls[] = new StartsWithKeyWord[1];
        urls[0] = new StartsWithKeyWord("/user/Pictures");
        EndpointFilter endpointFilter = new EndpointFilter(urls);
        assertTrue(endpointFilter.shouldFilter(keyWord));
    }

    /**
     * Adds StartsWithKeyWord array to the EndpointFilter and checks if
     * matches() method (in StartsWithKeyWord class) is invoked
     * and shouldFilter() method returns False whit incorrect keyWord.
     */

    @Test
    public void filterAddressWithKeyWordReturnsFalse(){
        final String keyWord = "user";
        StartsWithKeyWord urls[] = new StartsWithKeyWord[1];
        urls[0] = new StartsWithKeyWord("/guest/Documents");
        EndpointFilter endpointFilter = new EndpointFilter(urls);
        assertFalse(endpointFilter.shouldFilter(keyWord));
    }
}
