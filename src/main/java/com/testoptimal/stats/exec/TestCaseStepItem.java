/***********************************************************************************************
 * Copyright (c) 2009-2024 TestOptimal.com
 *
 * This file is part of TestOptimal MBT.
 *
 * TestOptimal MBT is free software: you can redistribute it and/or modify it under the terms of 
 * the GNU General Public License as published by the Free Software Foundation, either version 3 
 * of the License, or (at your option) any later version.
 *
 * TestOptimal MBT is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See 
 * the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with TestOptimal MBT. 
 * If not, see <https://www.gnu.org/licenses/>.
 ***********************************************************************************************/

package com.testoptimal.stats.exec;

public class TestCaseStepItem {
	public String assertCode;
	public String reqTag;
	public ModelExec.Status status = ModelExec.Status.failed;
	public String checkMsg;
	
	public TestCaseStepItem(String reqTag_p, ModelExec.Status passed_p, String checkMsg_p, String assertCode_p) {
		this.reqTag = reqTag_p;
		this.checkMsg = checkMsg_p;
		this.assertCode = assertCode_p;
		this.status = passed_p;
	}
	
	
	public boolean isPassed () {
		return this.status == ModelExec.Status.passed;
	}
	
}
