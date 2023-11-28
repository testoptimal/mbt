package com.testoptimal.stats;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.testoptimal.db.ModelExecDB;
import com.testoptimal.exec.FSM.ModelMgr;
import com.testoptimal.util.FileUtil;

public class SimpleStatsMgr implements ManageStats {

	@Override
	public List<ModelExecDB> getStatsList(ModelMgr modelMgr_p) throws Exception {
		Gson gson = new Gson();
		File[] flist = FileUtil.getFileList(modelMgr_p.getStatsFolderPath());
		List<ModelExecDB> retList = Arrays.asList(flist).stream()
		.filter(f -> f.getName().endsWith(".json"))
		.map(f -> {
			try {
				ModelExecDB execStats = gson.fromJson(FileUtil.readFile(f.getAbsolutePath()).toString(), ModelExecDB.class);
				return execStats;
			}
			catch (Exception e) {
				// skip
				return null;
			}
		}).filter(s -> s!=null).collect(Collectors.toList());
		retList.sort((o1, o2) -> o1.execSummary.startDT.compareTo(o2.execSummary.startDT));
		Collections.reverse(retList);
		return retList;
	}

	@Override
	public ModelExecDB getStats(ModelMgr modelMgr_p, String mbtSessID_p) throws Exception {
		Gson gson = new Gson();
		return gson.fromJson(FileUtil.readFile(modelMgr_p.getStatsFolderPath() + mbtSessID_p + ".json").toString(), ModelExecDB.class);
	}

	@Override
	public void save(ModelExecDB execStats_p) throws Exception {
		Gson gson = new Gson();
		String statsJson = gson.toJson(execStats_p);
		FileUtil.writeToFile(execStats_p.filePath, statsJson);
		
	}

	@Override
	public int deleteStats(String modelName_p, List<String> mbtSessIDList_p) {
		String modelFolder = FileUtil.findModelFolder(modelName_p);
		if (!FileUtil.exists(modelFolder)) {
			return 0;
		}
		int deleted = (int) mbtSessIDList_p.stream()
			.map(m -> modelFolder + "/stats/" + m + ".json")
			.map(f -> {
				try {
					FileUtil.deleteOneFile(f);
					return f;
				}
				catch (Exception e) {
					return null;
				}
			})
			.filter(f -> f!=null)
			.count();
		return 0;
	}

}
