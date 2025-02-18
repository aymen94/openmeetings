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
package org.apache.openmeetings.core.remote;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import com.github.openjson.JSONObject;

class TestNotConnectedMocked extends BaseMockedTest {
	@Test
	void testNotConnected() {
		handler.onMessage(null, getBaseMsg());
	}

	@Test
	void testRecordingAllowed() {
		assertFalse(streamProcessor.recordingAllowed(null));
	}

	@Test
	void testStartRecording() {
		streamProcessor.startRecording(null);
	}

	@Test
	void testStopRecording() {
		streamProcessor.stopRecording(null);
	}

	@Test
	void testIsRecording() {
		assertFalse(streamProcessor.isRecording(null));
	}

	@Test
	void testGetRecordingUser() {
		assertEquals(new JSONObject().toString(), handler.getRecordingUser(null).toString());
	}
}
