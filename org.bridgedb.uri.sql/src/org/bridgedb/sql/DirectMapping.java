// BridgeDb,
// An abstraction layer for identifier mapping services, both local and online.
//
// Copyright 2006-2009  BridgeDb developers
// Copyright 2012-2013  Christian Y. A. Brenninkmeijer
// Copyright 2012-2013  OpenPhacts
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//
package org.bridgedb.sql;

import java.util.ArrayList;
import java.util.List;
import org.bridgedb.pairs.IdSysCodePair;

/**
 *
 * @author christian
 */
public class DirectMapping extends AbstractMapping{
    private final int id;
    private final int originalId;
    private final String predicate;
    private final String justification;
    private final String mappingSource;
    private final String mappingResource;
    
    public DirectMapping (IdSysCodePair source, IdSysCodePair target, int id, int symmetric, String predicate, String justification, 
            String mappingSource, String mappingResource){
        super(source, target);
        this.id = id;
        if (symmetric < 0){
            this.originalId = 0 - symmetric;
        } else {
            this.originalId = id;
        }
        this.predicate = predicate;
        this.justification = justification;
        this.mappingSource = mappingSource;
        this.mappingResource = mappingResource;
    }

    boolean createsLoop(IdSysCodePair targetRef){
        return getSource().getSysCode().equals(targetRef.getSysCode());
    }

}
