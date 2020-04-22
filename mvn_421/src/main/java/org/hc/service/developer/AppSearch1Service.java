package org.hc.service.developer;



import org.hc.pojo.DataDictionary;

import java.util.List;

public interface AppSearch1Service {
    List<DataDictionary> appStatus();
    List<DataDictionary> appFlatform();
}
