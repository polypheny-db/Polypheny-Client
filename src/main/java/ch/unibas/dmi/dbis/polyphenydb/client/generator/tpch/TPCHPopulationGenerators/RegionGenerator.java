package ch.unibas.dmi.dbis.polyphenydb.client.generator.tpch.TPCHPopulationGenerators;

/**
 * Created by manuelhuerbin on 29.04.17.
 */


/*
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
 */

import static com.google.common.base.Preconditions.checkNotNull;

import ch.unibas.dmi.dbis.polyphenydb.client.generator.tpch.objects.Region;
import com.google.common.collect.AbstractIterator;
import java.util.Iterator;


public class RegionGenerator
        implements Iterable<Region> {

    private static final int COMMENT_AVERAGE_LENGTH = 72;

    private final Distributions distributions;
    private final TextPool textPool;


    public RegionGenerator() {
        this( Distributions.getDefaultDistributions(), TextPool.getDefaultTestPool() );
    }


    public RegionGenerator( Distributions distributions, TextPool textPool ) {
        this.distributions = checkNotNull( distributions, "distributions is null" );
        this.textPool = checkNotNull( textPool, "textPool is null" );
    }


    @Override
    public Iterator<Region> iterator() {
        return new RegionGeneratorIterator( distributions.getRegions(), textPool );
    }


    private static class RegionGeneratorIterator
            extends AbstractIterator<Region> {

        private final Distribution regions;
        private final RandomText commentRandom;

        private int index;


        private RegionGeneratorIterator( Distribution regions, TextPool textPool ) {
            this.regions = regions;
            this.commentRandom = new RandomText( 1500869201, textPool, COMMENT_AVERAGE_LENGTH );
        }


        @Override
        protected Region computeNext() {
            if ( index >= regions.size() ) {
                return endOfData();
            }

            Region region = new Region( index,
                    index,
                    regions.getValue( index ),
                    commentRandom.nextValue() );

            commentRandom.rowFinished();
            index++;

            return region;
        }
    }
}
