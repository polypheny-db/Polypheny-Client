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

package ch.unibas.dmi.dbis.polyphenydb.client.generator.tpch.objects;


import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.Locale.ENGLISH;


public class Part implements TpchEntity {

    private final long rowNumber;
    private final long partKey;
    private final String name;
    private final String manufacturer;
    private final String brand;
    private final String type;
    private final int size;
    private final String container;
    private final long retailPrice;
    private final String comment;


    public Part( long rowNumber,
            long partKey,
            String name,
            String manufacturer,
            String brand,
            String type,
            int size,
            String container,
            long retailPrice,
            String comment ) {
        this.rowNumber = rowNumber;
        this.partKey = partKey;
        this.name = checkNotNull( name, "name is null" );
        this.manufacturer = checkNotNull( manufacturer, "manufacturer is null" );
        this.brand = checkNotNull( brand, "brand is null" );
        this.type = checkNotNull( type, "type is null" );
        this.size = size;
        this.container = checkNotNull( container, "container is null" );
        this.retailPrice = retailPrice;
        this.comment = checkNotNull( comment, "comment is null" );
    }


    @Override
    public long getRowNumber() {
        return rowNumber;
    }


    public long getPartKey() {
        return partKey;
    }


    public String getName() {
        return name;
    }


    public String getManufacturer() {
        return manufacturer;
    }


    public String getBrand() {
        return brand;
    }


    public String getType() {
        return type;
    }


    public int getSize() {
        return size;
    }


    public String getContainer() {
        return container;
    }


    public double getRetailPrice() {
        return retailPrice / 100.0;
    }


    public long getRetailPriceInCents() {
        return retailPrice;
    }


    public String getComment() {
        return comment;
    }


    @Override
    public String toLine() {
        return String.format( ENGLISH,
                "%d|%s|%s|%s|%s|%d|%s|%s|%s|",
                partKey,
                name,
                manufacturer,
                brand,
                type,
                size,
                container,
                GenerateUtils.formatMoney( retailPrice ),
                comment );
    }
}
