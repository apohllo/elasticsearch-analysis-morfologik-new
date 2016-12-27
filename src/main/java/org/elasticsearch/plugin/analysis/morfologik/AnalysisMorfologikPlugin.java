/*
 * Licensed to ElasticSearch and Shay Banon under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. ElasticSearch licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.plugin.analysis.morfologik;

import org.apache.lucene.analysis.Analyzer;
import org.elasticsearch.indices.analysis.AnalysisModule.AnalysisProvider;
import org.elasticsearch.index.analysis.AnalyzerProvider;
import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.index.analysis.pl.MorfologikAnalyzerProvider;
import org.elasticsearch.index.analysis.pl.MorfologikStemTokenFilterFactory;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

import static java.util.Collections.singletonMap;

import java.util.Map;

/**
 *
 */
public class AnalysisMorfologikPlugin extends Plugin implements AnalysisPlugin {

	@Override
    public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
        return singletonMap("morfologik_stem", MorfologikStemTokenFilterFactory::new);
    }

    @Override
    public Map<String, AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
        return singletonMap("morfologik", MorfologikAnalyzerProvider::new);
    }
	
    /*
    @Override
    public Collection<Module> nodeModules() {
        return Collections.<Module>singletonList(new MorfologikIndicesAnalysisModule());
    }
    */
}
