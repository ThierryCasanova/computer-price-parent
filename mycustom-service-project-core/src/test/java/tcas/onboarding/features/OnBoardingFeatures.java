/*
 * (C) Copyright 2006-2007 Nuxeo SA (http://nuxeo.com/) and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Nuxeo - initial API and implementation
 *
 * 
 */
/**
 * 
 */
package tcas.onboarding.features;

import org.nuxeo.ecm.automation.test.AutomationFeature;
import org.nuxeo.ecm.collections.core.test.CollectionFeature;
import org.nuxeo.runtime.test.runner.Deploy;
import org.nuxeo.runtime.test.runner.Features;
import org.nuxeo.runtime.test.runner.PartialDeploy;
import org.nuxeo.runtime.test.runner.RunnerFeature;
import org.nuxeo.runtime.test.runner.TargetExtensions;

import com.nuxeo.studio.StudioConstant;

/**
 * @author tcasanova
 *
 */
@Features({ AutomationFeature.class, CollectionFeature.class })
@Deploy({"tcas.onboarding.computer-price-core"})
@PartialDeploy(bundle = StudioConstant.BUNDLE_NAME, extensions = {TargetExtensions.ContentModel.class })
public class OnBoardingFeatures  implements RunnerFeature {

}
