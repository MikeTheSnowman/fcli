/*******************************************************************************
 * (c) Copyright 2021 Micro Focus or one of its affiliates
 *
 * Permission is hereby granted, free of charge, to any person obtaining a 
 * copy of this software and associated documentation files (the 
 * "Software"), to deal in the Software without restriction, including without 
 * limitation the rights to use, copy, modify, merge, publish, distribute, 
 * sublicense, and/or sell copies of the Software, and to permit persons to 
 * whom the Software is furnished to do so, subject to the following 
 * conditions:
 * 
 * The above copyright notice and this permission notice shall be included 
 * in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY 
 * KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE 
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR 
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE 
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, 
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN 
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS 
 * IN THE SOFTWARE.
 ******************************************************************************/
package com.fortify.cli.common.output;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.function.Supplier;

import com.fortify.cli.common.json.transform.IHeaderProvider;
import com.fortify.cli.common.json.transform.IJsonNodeTransformer;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class OutputWriterConfig {
	@Builder.Default private Supplier<Writer> writerSupplier = ()->new PrintWriter(System.out);
	private IJsonNodeTransformer transformer;
	private boolean headersEnabled;
	
	public final IHeaderProvider getHeaderProvider(boolean required) {
		IHeaderProvider result = null;
		if ( transformer instanceof IHeaderProvider ) {
			result = (IHeaderProvider)transformer;
		} else if ( required ) { 
			throw new IllegalArgumentException("Header provider not available");
		}
		return result;
	}
}