package com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class SportsMain {

	public static void main(String[] args) {
		int a=0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Scanner scan=new Scanner(System.in);
		System.out.println("enter Number of players");
		a=scan.nextInt();
		String name[]=new String[a];
		String opposition[]=new String[a];
		int jnum=0;
		int runs[]=new int[a];
		int mins[]=new int[a];
		float overs[]=new float[a];
		String status[]=new String[a];
		try{
			String fname="F:/sports.txt";
			int jerseyn=0;
			File file=new File(fname);
			if(!file.exists()){
				file.createNewFile();
			}
			FileWriter fw=new FileWriter(file,true);
			BufferedWriter bw=new BufferedWriter(fw);
//			PrintWriter pw=new PrintWriter(file);
//			pw.write("");
			System.out.println("enter opposition names");
			for(int i=0,j=1;i<a;i++,j++){
				opposition[i]=br.readLine();
				String str=j+"-"+opposition[i];
				bw.write(str);
			}
			bw.close();
			for(int k=0;k<a;k++){
				System.out.println("enter name");
				name[k]=br.readLine();
				System.out.println("enter runs");
				runs[k]=scan.nextInt();
				System.out.println("enter mins");
				mins[k]=scan.nextInt();
				System.out.println("enter overs");
				overs[k]=scan.nextFloat();
				System.out.println("enter status");
				status[k]=br.readLine();
				if(status[k].equals("out")){
					System.out.println("enter jersey number");
					jerseyn=scan.nextInt();
				}
			}
			System.out.println("player name"+"       "+"runs"+"       "+"status"+"       "+"mins"+"       "+"overs");
			try{
				for(int l=0;l<a;l++){				
					BufferedReader br1=new BufferedReader(new FileReader(fname));
					String line=null;
					String jenum=null;
					while((line=br1.readLine())!=null){
						String st[]=line.split("-");
						jenum=st[0];
						jnum=Integer.parseInt(jenum);
						if(jerseyn==jnum){
							String n=st[1];
							System.out.println(name[l]+"        "+runs[l]+"        "+"outby"+n+"       "+mins[l]+"        "+overs[l]);
						}
						System.out.println(name[l]+"        "+runs[l]+"        "+"notout"+"       "+mins[l]+"        "+overs[l]);
					}
				}
			}
				catch(Exception e){
					e.getClass();
				}
			
		}
		catch(Exception e){
			e.getMessage();
		}
	}

}
