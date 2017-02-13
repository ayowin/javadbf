package com.linuxense.javadbf;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

import com.linuxense.javadbf.testutils.AssertUtils;

public class FixtureDBase31Test {

	@Test
	public void test31 () throws Exception {
		File file = new File("src/test/resources/fixtures/dbase_31.dbf");
		InputStream inputStream = null;
		try {
			inputStream = new BufferedInputStream(new FileInputStream(file));
			DBFReader reader = new DBFReader(inputStream);
			
			DBFHeader header = reader.getHeader();
			Assert.assertNotNull(header);
			Assert.assertEquals(11, header.fieldArray.length);
			Assert.assertEquals(77, header.numberOfRecords);
			DBFField []fieldArray = header.fieldArray;
			
			int i = 0;
			
			AssertUtils.assertColumnDefinition(fieldArray[i++], "PRODUCTID",  DBFDataType.fromCode((byte) 'I'), 4  ,0);         
			AssertUtils.assertColumnDefinition(fieldArray[i++], "PRODUCTNAM", DBFDataType.fromCode((byte) 'C'), 40 ,0);         
			AssertUtils.assertColumnDefinition(fieldArray[i++], "SUPPLIERID", DBFDataType.fromCode((byte) 'I'), 4  ,0);         
			AssertUtils.assertColumnDefinition(fieldArray[i++], "CATEGORYID", DBFDataType.fromCode((byte) 'I'), 4  ,0);         
			AssertUtils.assertColumnDefinition(fieldArray[i++], "QUANTITYPE", DBFDataType.fromCode((byte) 'C'), 20 ,0);         
			AssertUtils.assertColumnDefinition(fieldArray[i++], "UNITPRICE",  DBFDataType.fromCode((byte) 'Y'), 8  ,4);         
			AssertUtils.assertColumnDefinition(fieldArray[i++], "UNITSINSTO", DBFDataType.fromCode((byte) 'I'), 4  ,0);         
			AssertUtils.assertColumnDefinition(fieldArray[i++], "UNITSONORD", DBFDataType.fromCode((byte) 'I'), 4  ,0);         
			AssertUtils.assertColumnDefinition(fieldArray[i++], "REORDERLEV", DBFDataType.fromCode((byte) 'I'), 4  ,0);         
			AssertUtils.assertColumnDefinition(fieldArray[i++], "DISCONTINU", DBFDataType.fromCode((byte) 'L'), 1  ,0);
			AssertUtils.assertColumnDefinition(fieldArray[i++], "_NullFlags", DBFDataType.UNKNOWN, 1  ,0);
			// TODO Detect and read flags field type
			//			AssertUtils.assertColumnDefinition(fieldArray[i++], "_NullFlags", DBFDataType.fromCode((byte) '0'), 1  ,0);   
			                                                                                                          
			Object[] row = null;
			
			while (( row = reader.nextRecord()) != null) {
				for (Object o : row) {
					System.out.print(o + ";");
				}
				System.out.println("");
			}
			



			
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}

	}
	
}



/*
 Database: dbase_31.dbf
Type: (31) Visual FoxPro with AutoIncrement field
Memo File: false
Records: 77

Fields:
Name             Type       Length     Decimal
------------------------------------------------------------------------------
PRODUCTID        I          4          0         
PRODUCTNAM       C          40         0         
SUPPLIERID       I          4          0         
CATEGORYID       I          4          0         
QUANTITYPE       C          20         0         
UNITPRICE        Y          8          4         
UNITSINSTO       I          4          0         
UNITSONORD       I          4          0         
REORDERLEV       I          4          0         
DISCONTINU       L          1          0         
_NullFlags       0          1          0         
*/
