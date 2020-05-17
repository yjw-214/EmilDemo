package cn.yxw.em;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.Scanner;
import java.io.InputStream;

public class Chatbot {
	
	public static String decode(String unicodeStr) {
		if(unicodeStr == null) {	            
			return null;	        
		}	        
		StringBuffer retBuf = new StringBuffer();
		int maxLoop = unicodeStr.length();	        
		for(int i = 0; i < maxLoop; i++) {	            
			if(unicodeStr.charAt(i) == '\\') {	                
				if((i < maxLoop - 5) && ((unicodeStr.charAt(i + 1) == 'u') || (unicodeStr.charAt(i + 1) == 'U')))	                    
					try {	                        
						retBuf.append((char) Integer.parseInt(unicodeStr.substring(i + 2, i + 6), 16));	                        
						i += 5;	                    
					} catch (NumberFormatException localNumberFormatException) {	                        
						retBuf.append(unicodeStr.charAt(i));	                    
					}	                
				else	                    
					retBuf.append(unicodeStr.charAt(i));	            
			} else {	                
				retBuf.append(unicodeStr.charAt(i));	            
			}	        
		}	        
		return retBuf.toString();	    
	}


	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("========================================");
		System.out.println();
		System.out.println("\t- 欢迎使用小飞聊天机器人 -");
		System.out.println();
		System.out.println("========================================");
		System.out.print("现在请输入您的昵称：");
		String nc = sc.next();
		System.out.println("========================================");
		while (true) {
			System.out.print(MessageFormat.format("{0}：", nc));
			String input = sc.next();
			String name= URLEncoder.encode(input,"utf-8");
			if (input.equals("退出")) {
				System.out.println("========================================");
				System.out.println("您已退出聊天！");
				break;
			} else {
				StringBuffer buffer = new StringBuffer();
				String urlStr = "http://i.itpk.cn/api.php?question=" + name;
			    try {
			        URL url = new URL(urlStr);
			        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			        connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			        InputStream a = url.openStream();
			        InputStreamReader inStrRead = new InputStreamReader(a, "utf-8");
			        BufferedReader bufRead = new BufferedReader(inStrRead);
			        String line;
			        int i = 1;
			        while ((line = bufRead.readLine()) != null) {
			        	if (i == 1) {
			        		buffer.append(line);
						} else {
							buffer.append( "\n          " +line);
						}
			        	i += 1;
			        }
			        i = 1;
			        line = buffer.toString();
			        if (line.contains("title")) {
		        		line = line.substring(line.indexOf("content\":\""), line.indexOf("\"}"));
		        		line = line.substring(10);
		        		line = decode(line);
		        		line = line.replace("\\r\\n", "\n          ");
		        		line = line.replace("&nbsp;", " ");
		        		System.out.println();
		        		System.out.println(MessageFormat.format("小飞：{0}", line));
		        		System.out.println();
		        	} else {
						line = line.substring(1);
						line = line.replace("[father]", "李朋飞");
						line = line.replace("[name]", "你");
						line = line.replace("[cqname]", "小飞");
						System.out.println();
						System.out.println(MessageFormat.format("小飞：{0}", line));
						System.out.println();
					}
			        bufRead.close();
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
			}
		}
		sc.close();
	}
}