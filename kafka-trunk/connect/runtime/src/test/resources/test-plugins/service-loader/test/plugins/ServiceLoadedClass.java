/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package test.plugins;

import org.apache.kafka.connect.runtime.isolation.SamplingTestPlugin;

/**
 * Superclass for service loaded classes
 */
public class ServiceLoadedClass implements SamplingTestPlugin {

  private static final ClassLoader STATIC_CLASS_LOADER;
  private final ClassLoader classloader;

  static {
    STATIC_CLASS_LOADER = Thread.currentThread().getContextClassLoader();
  }

  {
    classloader = Thread.currentThread().getContextClassLoader();
  }

  @Override
  public ClassLoader staticClassloader() {
    return STATIC_CLASS_LOADER;
  }

  @Override
  public ClassLoader classloader() {
    return classloader;
  }

}
