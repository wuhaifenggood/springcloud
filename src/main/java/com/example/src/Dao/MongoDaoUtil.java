package com.example.src.Dao;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.example.src.Po.MongoSequence;

@Component
public class MongoDaoUtil {

	@Resource(name="primaryMongoTemplate")
	private MongoTemplate primaryMongoTemplate;

	public int getNextSequence(String collectionName) {
		MongoSequence seq = primaryMongoTemplate.findAndModify(
				new Query(where("_id").is(collectionName)),
				new Update().inc("seq", 1),
				new FindAndModifyOptions().upsert(true).returnNew(true),
				MongoSequence.class);
		return seq.getSeq();
	}
}
