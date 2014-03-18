package com.stratio.meta.metadata;

import com.stratio.meta.cassandra.BasicCassandraTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by dhiguero on 3/17/14.
 */
public class LuceneIndexHelperTest extends BasicCassandraTest {

    @BeforeClass
    public static void setUpBeforeClass(){
        BasicCassandraTest.setUpBeforeClass();
        BasicCassandraTest.loadTestData("demo", "demoKeyspace.cql");
    }

    @Test
    public void processLuceneOptions(){
        String options = "{\"schema\":\"{default_analyzer:\\\"org.apache.lucene.analysis.standard.StandardAnalyzer\\\",fields:{name:{type:\\\"string\\\"}, gender:{type:\\\"string\\\"}, email:{type:\\\"string\\\"}, age:{type:\\\"integer\\\"}, bool:{type:\\\"boolean\\\"}, phrase:{type:\\\"text\\\", analyzer:\\\"org.apache.lucene.analysis.en.EnglishAnalyzer\\\"}}}\",\"refresh_seconds\":\"1\",\"class_name\":\"org.apache.cassandra.db.index.stratio.RowIndex\"}";
        int numColumns = 6;
        LuceneIndexHelper lih = new LuceneIndexHelper();
        Map<String, List<CustomIndexMetadata>> indexes = lih.processLuceneOptions(null, options);
        assertEquals("Invalid number of indexes", numColumns, indexes.size());

        for(Map.Entry<String, List<CustomIndexMetadata>> entry : indexes.entrySet()){
            assertEquals("Column has several indexes", 1, entry.getValue().size());
            assertEquals("Invalid type of index", IndexType.CUSTOM, entry.getValue().get(0).getIndexType());
        }

        Set<Map.Entry<String,List<CustomIndexMetadata>>> entries = indexes.entrySet();
        for(entry : entries){


        }

    }

}