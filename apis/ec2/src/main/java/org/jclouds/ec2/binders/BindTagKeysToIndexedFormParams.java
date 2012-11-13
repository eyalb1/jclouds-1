/**
 * Licensed to jclouds, Inc. (jclouds) under one or more
 * contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  jclouds licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jclouds.ec2.binders;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Singleton;

import org.jclouds.aws.util.AWSUtils;
import org.jclouds.http.HttpRequest;
import org.jclouds.rest.Binder;

import com.google.common.collect.Iterables;

/**
 * Binds the Iterable<String> to form parameters named with Tag.index.Key
 * 
 * @author Adrian Cole
 */
@Singleton
public class BindTagKeysToIndexedFormParams implements Binder {
   @Override
   public <R extends HttpRequest> R bindToRequest(R request, Object input) {
      checkArgument(checkNotNull(input, "input") instanceof Iterable, "This binder is only valid for Iterable<String>");
      @SuppressWarnings("unchecked")
      Iterable<String> keys = (Iterable<String>) input;
      return AWSUtils.indexStringArrayToFormValuesWithStringFormat(request, "Tag.%s.Key",
            Iterables.toArray(keys, String.class));
   }

}