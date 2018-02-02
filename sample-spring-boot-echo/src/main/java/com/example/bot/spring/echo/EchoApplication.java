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
        if(event.getMessage().getText().indexOf("ดีครับ")!=-1 || 
				event.getMessage().getText().indexOf("ดีคับ")!=-1){
        	result = "สวัสดีครับ RsShop ยินดีต้อนรับ สอบถามเกี่ยวกับสินค้าตัวไหนครับ ";
        }else if(event.getMessage().getText().indexOf("บัญชี")!=-1 || 
				event.getMessage().getText().indexOf("บช")!=-1){
			StringBuilder str = new StringBuilder();
			str.append("กสิกรไทย\n" + 
					"6192018313\n" + 
					"ธีรวัฒน์ ภาสวงศ์ตระกูล\n" + 
					"หรือ Prompay (พร้อมเพย์) 0894879738");
			result = str.toString();
		}else if(event.getMessage().getText().indexOf("ไทเท")!=-1){
			StringBuilder str = new StringBuilder();
			str.append("สนใจน็อต size ไหนขนาดเท่าไหร่ครับ ");
			str.append("M5x10-13-17-20-35 \n" + 
				"M6x10-20-25-30-35-40-45-50-65\n" + 
				"M8x30-35\n" + 
				"M10 pre oder\n" + 
				"\n" + 
				"M5 เริ่มต้น 140 ครับ ขยับ size ละ 10 บาท\n" + 
				"M6 เริ่มต้น 150 ครับ ขยับ size ละ 10 บาท\n" + 
				"M8 30mm 250 35mm 280");
			result = str.toString();
		}else if(event.getMessage().getText().indexOf("มีรูปมั้ย")!=-1){
			result = "เดี๋ยวหาก่อนครับ ฝากติดตามเพจด้วยครับผม https://www.facebook.com/Mazda2RotaryShop/";
		}else if(event.getMessage().getText().indexOf("ขอเบอร์โทร")!=-1 || 
				event.getMessage().getText().indexOf("ขอเบอโทร")!=-1){
			result = "0894879738 ครับ";
		}else if(event.getMessage().getText().indexOf("มีเพจมั้ย")!=-1){
			result = "https://www.facebook.com/Mazda2RotaryShop/";
		}else if(event.getMessage().getText().indexOf("ถุยยย")!=-1){
			result = "ไม่สุภาพเลยนะครับ กรุณาใช้ถ้อยคำที่สุภาพหน่อยครับ ผมเป็น Bot ก็มีหัวใจนะครับ";
		}else if(event.getMessage().getText().indexOf("ถามแฟนก่อน")!=-1){
			result = "ทีหลังรบกวนถามแฟนมาให้เรียบร้อยก่อนนะครับ ตอบแทบตาย สุดท้าย ถามแฟนก่อน อุ๊ย ขออภัยครับ ผมเป็น Botนะ";
		}else if(event.getMessage().getText().indexOf("ไอ้สัส")!=-1){
			result = "ขอบคุณครับ ผมขอเป็นแมวน้ำนะ น่ารักดี อุ๋ง อุ๋ง";
		}else if(event.getMessage().getText().indexOf("ไอ้เหี้ย")!=-1){
			result = "สงสารมันนะครับ มันไม่ได้ทำอะไรผิดเลย";
		}else if(event.getMessage().getText().indexOf("ขอเงินหน่อย")!=-1){
			result = "ไปทำงานหาเงิน เอาเองสิครับ";		
		}else if(event.getMessage().getText().indexOf("น็อตฟรี")!=-1){
			result = "ไม่มีครับ ของซื้อของขายนะ";						
		}
		return new TextMessage(result);
    }

    @EventMapping
    public void handleDefaultMessageEvent(Event event) {
        System.out.println("event: " + event);
    }
}
