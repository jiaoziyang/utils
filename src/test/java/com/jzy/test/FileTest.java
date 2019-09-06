package com.jzy.test;

import java.io.File;

import org.junit.Test;

import com.jzy.utils.FileUtils;

public class FileTest {

	@Test
	public void testFile() {
		
		String suffixName = FileUtils.getSuffixName("F:\\ר��һ\\2019-09-Сһ\\git\\Git&GitHub.pdf");
		System.out.println(suffixName);
	}
	@Test
	public void testDelete() {
		//FileUtils.deleteFiles("D:\\workSpace\\08E");
		/*String homeDirectory = FileUtils.getWorkDirectory();
		System.out.println(homeDirectory);*/
		String fileSize = FileUtils.getFileSize("F:\\ר��һ\\2019-09-Сһ\\git\\Git&GitHub.pdf","M");		
		System.out.println(fileSize);
	}
}
