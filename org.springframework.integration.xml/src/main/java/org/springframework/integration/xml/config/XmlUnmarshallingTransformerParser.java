/*
 * Copyright 2002-2008 the original author or authors.
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

package org.springframework.integration.xml.config;

import org.w3c.dom.Element;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.integration.transformer.Transformer;
import org.springframework.integration.transformer.config.AbstractTransformerParser;
import org.springframework.integration.xml.transformer.XmlPayloadUnmarshallingTransformer;
import org.springframework.util.Assert;

/**
 * @author Jonas Partner
 * @author Mark Fisher
 */
public class XmlUnmarshallingTransformerParser extends AbstractTransformerParser {

	@Override
	protected Class<? extends Transformer> getTransformerClass() {
		return XmlPayloadUnmarshallingTransformer.class;
	}

	@Override
	protected void parsePayloadTransformer(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
		String unmarshaller = element.getAttribute("unmarshaller");
		Assert.hasText(unmarshaller, "the 'unmarshaller' attribute is required");
		builder.addConstructorArgReference(unmarshaller);
	}

}
