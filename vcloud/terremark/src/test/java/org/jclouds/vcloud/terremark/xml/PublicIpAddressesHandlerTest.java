/**
 *
 * Copyright (C) 2009 Cloud Conscious, LLC. <info@cloudconscious.com>
 *
 * ====================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ====================================================================
 */
package org.jclouds.vcloud.terremark.xml;

import static org.testng.Assert.assertEquals;

import java.io.InputStream;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.SortedSet;

import org.jclouds.http.functions.BaseHandlerTest;
import org.jclouds.vcloud.terremark.domain.PublicIpAddress;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableSortedSet;

/**
 * Tests behavior of {@code PublicIpAddressesHandler}
 * 
 * @author Adrian Cole
 */
@Test(groups = "unit", testName = "terremark.PublicIpAddressesHandlerTest")
public class PublicIpAddressesHandlerTest extends BaseHandlerTest {

   public void test1() throws UnknownHostException {
      InputStream is = getClass().getResourceAsStream("/terremark/PublicIpAddresses.xml");

      SortedSet<PublicIpAddress> result = factory.create(
               injector.getInstance(PublicIpAddressesHandler.class)).parse(is);
      assertEquals(
               result,
               ImmutableSortedSet
                        .of(
                                 new PublicIpAddress(
                                          8720,
                                          "204.51.112.91",
                                          URI
                                                   .create("https://services.vcloudexpress.terremark.com/api/v0.8/PublicIps/8720")),
                                 new PublicIpAddress(
                                          14965,
                                          "204.51.114.79",
                                          URI
                                                   .create("https://services.vcloudexpress.terremark.com/api/v0.8/PublicIps/14965"))));

   }
}
