/*
 * Copyright 2008-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codehaus.griffon.runtime.swing;

import griffon.core.GriffonApplication;
import griffon.core.GriffonController;
import griffon.core.controller.GriffonControllerAction;
import org.codehaus.griffon.runtime.core.controller.AbstractGriffonControllerActionManager;

/**
 * @author Andres Almiray
 * @since 1.1.0
 */
public class SwingGriffonControllerActionManager extends AbstractGriffonControllerActionManager {
    protected SwingGriffonControllerActionManager(GriffonApplication app) {
        super(app);
    }

    @Override
    protected GriffonControllerAction createControllerAction(GriffonController controller, String actionName) {
        return new SwingGriffonControllerAction(controller, actionName);
    }
}