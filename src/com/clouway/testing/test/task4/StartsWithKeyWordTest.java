package com.clouway.testing.test.task4;

import com.clouway.testing.task4.EndpointFilter;
import com.clouway.testing.task4.StartsWithKeyWord;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class StartsWithKeyWordTest {
    StartsWithKeyWord urls = new StartsWithKeyWord("/user/Pictures");

    /**
     * Adds StartsWithKeyWord object to the EndpointFilter and checks if
     * matches() method (in StartsWithKeyWord class) is invoked
     * and shouldFilter() method returns True with correct keyWord.
     */

    @Test
    public void filterAddressWithKeyWordReturnsTrue(){ //Happy path
        final String keyWord = "/user";
        EndpointFilter endpointFilter = new EndpointFilter(urls);
        assertTrue(endpointFilter.shouldFilter(keyWord));
    }

    /**
     * Adds StartsWithKeyWord object to the EndpointFilter and checks if
     * matches() method (in StartsWithKeyWord class) is invoked
     * and shouldFilter() method returns False without the correct keyWord.
     */

    @Test
    public void filterAddressWithKeyWordReturnsFalse(){
        final String keyWord = "/guest";
        EndpointFilter endpointFilter = new EndpointFilter(urls);
        assertFalse(endpointFilter.shouldFilter(keyWord));
    }
}
