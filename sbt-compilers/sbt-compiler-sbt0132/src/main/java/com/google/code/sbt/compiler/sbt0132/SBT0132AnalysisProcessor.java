/*
 * Copyright 2013-2014 Grzegorz Slowikowski (gslowikowski at gmail dot com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
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

package com.google.code.sbt.compiler.sbt0132;

import java.io.File;

import com.typesafe.zinc.Compiler$;

import com.google.code.sbt.compiler.api.Analysis;
import com.google.code.sbt.compiler.api.AnalysisProcessor;

import org.codehaus.plexus.component.annotations.Component;

/**
 * SBT 0.13.2 compatible analysis processor
 * 
 * @author <a href="mailto:gslowikowski@gmail.com">Grzegorz Slowikowski</a>
 */
@Component( role = com.google.code.sbt.compiler.api.AnalysisProcessor.class, hint = "sbt0132", description = "SBT 0.13.2 analysis processor" )
public class SBT0132AnalysisProcessor
    implements AnalysisProcessor
{
    @Override
    public boolean areClassFileTimestampsSupported()
    {
        return true;
    }

    @Override
    public Analysis readFromFile( File analysisFile )
    {
        return new SBT0132Analysis( Compiler$.MODULE$.analysis( analysisFile ) );
    }

}