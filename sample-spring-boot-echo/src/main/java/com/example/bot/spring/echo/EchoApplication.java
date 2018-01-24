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
	@Autowired
    private LineMessagingClient lineMessagingClient;

    public static void main(String[] args) {
        SpringApplication.run(EchoApplication.class, args);
    }

    @EventMapping
    public TextMessage handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
	   String text = event.getMessage().getText();
       String result ="";
		if(text.indexOf("บัญชี")!=-1 || 
				text.indexOf("บช")!=-1){
			StringBuilder str = new StringBuilder();
			str.append("กสิกรไทย\n" + 
					"6192018313\n" + 
					"ธีรวัฒน์ ภาสวงศ์ตระกูล\n" + 
					"หรือ Prompay (พร้อมเพย์) 0894879738");
			result = str.toString();
		}
		
		if(text.indexOf("ไทเท")!=-1){
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
		}

		if(text.equals("RsShop ออกไป") {
                Source source = event.getSource();
                if (source instanceof GroupSource) {
                    this.replyText(replyToken, "Leaving group");
                    lineMessagingClient.leaveGroup(((GroupSource) source).getGroupId()).get();
                } else if (source instanceof RoomSource) {
                    this.replyText(replyToken, "Leaving room");
                    lineMessagingClient.leaveRoom(((RoomSource) source).getRoomId()).get();
                } else {
                    this.replyText(replyToken, "Bot can't leave from 1:1 chat");
                }
             
        }

		return new TextMessage(result);
    }

    @EventMapping
    public void handleDefaultMessageEvent(Event event) {
        System.out.println("event: " + event);
    }

	@EventMapping
    public void handleStickerMessageEvent(MessageEvent<StickerMessageContent> event) {
        handleSticker(event.getReplyToken(), event.getMessage());
    }

    @EventMapping
    public void handleLocationMessageEvent(MessageEvent<LocationMessageContent> event) {
        LocationMessageContent locationMessage = event.getMessage();
        reply(event.getReplyToken(), new LocationMessage(
                locationMessage.getTitle(),
                locationMessage.getAddress(),
                locationMessage.getLatitude(),
                locationMessage.getLongitude()
        ));
    }

	private void handleSticker(String replyToken, StickerMessageContent content) {
        reply(replyToken, new StickerMessage(
                content.getPackageId(), content.getStickerId())
        );
    }
}
