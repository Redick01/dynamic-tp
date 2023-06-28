/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.dromara.dynamictp.core.plugin;


import java.lang.reflect.InvocationTargetException;

/**
 * Extension interface
 * @author windsearcher.lq
 * @since  22:22
 */
public interface DtpExtension {

    Object intercept(DtpInvocation invocation) throws InvocationTargetException, IllegalAccessException;

    default Object plugin(Object target) {
        return DtpExtensionProxyFactory.wrap(target, this);
    }

    default Object plugin(Object target, Class[] argumentTypes, Object[] arguments) {
        return DtpExtensionProxyFactory.wrap(target, argumentTypes, arguments, this);
    }
}
