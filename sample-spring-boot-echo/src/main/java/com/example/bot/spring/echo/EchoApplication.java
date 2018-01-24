/*
 * Copyright 2016 LINE Corporation
 *
 * LINE Corporation licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.example.bot.spring.echo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;

@SpringBootApplication
@LineMessageHandler
public class EchoApplication {
    public static void main(String[] args) {
        SpringApplication.run(EchoApplication.class, args);
    }

    @EventMapping
    public TextMessage handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
       String result ="";
		if(event.getMessage().getText().indexOf("�ѭ��")!=-1 || 
				event.getMessage().getText().indexOf("��")!=-1){
			StringBuilder str = new StringBuilder();
			str.append("��ԡ���\n" + 
					"6192018313\n" + 
					"����Ѳ�� ���ǧ���С��\n" + 
					"���� Prompay (��������) 0894879738");
			result = str.toString();
		}
		
		if(event.getMessage().getText().indexOf("��")!=-1){
			StringBuilder str = new StringBuilder();
			str.append("ʹ㨹�͵ size �˹��Ҵ��������Ѻ ");
			str.append("M5x10-13-17-20-35 \n" + 
				"M6x10-20-25-30-35-40-45-50-65\n" + 
				"M8x30-35\n" + 
				"M10 pre oder\n" + 
				"\n" + 
				"M5 ������� 140 ��Ѻ ��Ѻ size �� 10 �ҷ\n" + 
				"M6 ������� 150 ��Ѻ ��Ѻ size �� 10 �ҷ\n" + 
				"M8 30mm 250 35mm 280");
			result = str.toString();
		}
		return new TextMessage(result);
    }

    @EventMapping
    public void handleDefaultMessageEvent(Event event) {
        System.out.println("event: " + event);
    }
}
