/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License") +  you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
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
package org.apache.openmeetings.userdata;

import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.apache.openmeetings.db.dao.server.SessiondataDao;
import org.apache.openmeetings.db.entity.server.Sessiondata;
import org.apache.openmeetings.web.test.AbstractOmServerTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class TestAuth extends AbstractOmServerTest {
	@Autowired
	private SessiondataDao sessionDao;

	@Test
	void test() {
		Sessiondata sd = sessionDao.create(1L, 1L);
		assertNotNull(sd);
		sessionDao.clearSessionTable(-1L);
	}

	@Test
	void testNotExistent() {
		Sessiondata sd = sessionDao.check(randomUUID().toString());
		assertNotNull(sd);
	}

	@Test
	void testFind1() {
		assertNull(sessionDao.find(null));
	}

	@Test
	void testFind2() {
		assertNull(sessionDao.find(randomUUID().toString()));
	}
}
