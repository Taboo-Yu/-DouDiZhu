package com;
import java.applet.AudioClip; 
import java.io.*; 
import java.applet.Applet; 
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL; 

public class qiangdizhu { 
    String name="������.wav";//��������ѡ������Ҫ���ŵ�����
    File f = new File("music/"+name); //�������ļ���·����ע��һ��Ҫ��WAV��ʽ�����ֲ�Ȼ�����Բ���
     URL url; 
     URI uri;
     AudioClip clip; 
   
    void setMusic(String name)//�޸Ĳ��ŵ������ļ�
    {
        this.name=name;

    }
   
  public qiangdizhu(){    
     try
     {  
        uri=f.toURI();
        url = uri.toURL();
        clip = Applet.newAudioClip(url); 
        //clip.loop();//ѭ������
        clip.play();//����
        clip.stop();//ֹͣ����
       
        System.out.println("�����ļ��Ѿ���");
    }
     catch (MalformedURLException e) { 
            e.printStackTrace(); 
            System.out.println("���Ŵ���");
        }
  
     }
   public void stopqiangdizhu()//ֹͣ����
   {
       clip.stop();
   }
   public void playqiangdizhu()//����
   {
       clip.play();
   }
   public void loopqiangdizhu()//ѭ������
   {
       clip.loop();
   }
} 
