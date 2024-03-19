package edu.miu.cs.cs544.service.mapper;

import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs.cs544.domain.ScanRecord;
import edu.miu.cs.cs544.service.contract.ScanRecordPayload;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class ScanRecordToScanRecordPayloadMapper extends BaseMapper<ScanRecord, ScanRecordPayload> {
    public ScanRecordToScanRecordPayloadMapper(MapperFactory mapperFactory){
        super(mapperFactory, ScanRecord.class,ScanRecordPayload.class);
    }
}
