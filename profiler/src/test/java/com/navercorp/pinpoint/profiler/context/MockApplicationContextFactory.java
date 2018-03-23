/*
 * Copyright 2017 NAVER Corp.
 *
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
 */

package com.navercorp.pinpoint.profiler.context;

import com.navercorp.pinpoint.bootstrap.AgentOption;
import com.navercorp.pinpoint.bootstrap.DefaultAgentOption;
import com.navercorp.pinpoint.bootstrap.config.ProfilerConfig;
import com.navercorp.pinpoint.common.service.DefaultAnnotationKeyRegistryService;
import com.navercorp.pinpoint.common.service.DefaultServiceTypeRegistryService;
import com.navercorp.pinpoint.profiler.context.module.DefaultApplicationContext;
import com.navercorp.pinpoint.profiler.context.module.ModuleFactory;
import org.mockito.Mockito;

import java.lang.instrument.Instrumentation;
import java.net.URL;

/**
 * @author Woonduk Kang(emeroad)
 */
public class MockApplicationContextFactory {

    public MockApplicationContextFactory() {
    }


    public DefaultApplicationContext build(ProfilerConfig config, ModuleFactory moduleFactory) {
        Instrumentation instrumentation = Mockito.mock(Instrumentation.class);
        String mockAgent = "mockAgent";
        String mockApplicationName = "mockApplicationName";
        DefaultServiceTypeRegistryService serviceTypeRegistryService = new DefaultServiceTypeRegistryService();
        DefaultAnnotationKeyRegistryService annotationKeyRegistryService = new DefaultAnnotationKeyRegistryService();
        AgentOption agentOption = new DefaultAgentOption(instrumentation, mockAgent, mockApplicationName, config, new URL[0], null, serviceTypeRegistryService, annotationKeyRegistryService);
        return new MockApplicationContext(agentOption, moduleFactory);
    }


}
