/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : souljourney

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2023-04-18 14:27:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `adminUid` varchar(16) NOT NULL,
  `adminPassword` varchar(16) NOT NULL,
  `adminName` varchar(8) NOT NULL,
  PRIMARY KEY (`adminId`),
  UNIQUE KEY `adminUid` (`adminUid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'admin', '最高管理员');
INSERT INTO `admin` VALUES ('2', '1234', '1234', '管理员一号');
INSERT INTO `admin` VALUES ('3', 'abc', 'abc', 'abc');
INSERT INTO `admin` VALUES ('4', '12345', '12345', '12345');
INSERT INTO `admin` VALUES ('5', 'a', 'a', 'a');
INSERT INTO `admin` VALUES ('6', '123', '123', '123');
INSERT INTO `admin` VALUES ('7', 'ab', 'ab', 'ab');
INSERT INTO `admin` VALUES ('8', '123456', '123456', '123456');
INSERT INTO `admin` VALUES ('12', '8109', '8109', 'ceshi');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `commentId` int(11) NOT NULL AUTO_INCREMENT,
  `commentPostId` int(11) NOT NULL,
  `commentUserId` int(11) NOT NULL,
  `commentContent` varchar(255) NOT NULL,
  `commentCreateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`commentId`),
  KEY `commentPostId` (`commentPostId`),
  KEY `commentUserId` (`commentUserId`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`commentPostId`) REFERENCES `post` (`postId`),
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`commentUserId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '1', '2', '这是一个评论测试用例1', '2022-04-11 10:25:34');
INSERT INTO `comment` VALUES ('2', '1', '3', '这是一个评论测试用例2', '2022-04-11 19:58:32');
INSERT INTO `comment` VALUES ('3', '1', '2', '这是一个评论测试用例3', '2022-04-11 19:58:47');
INSERT INTO `comment` VALUES ('4', '1', '4', '这是一个评论测试用例4', '2022-04-11 19:59:01');
INSERT INTO `comment` VALUES ('5', '1', '2', '这是一个评论测试用例5', '2022-04-11 19:59:44');
INSERT INTO `comment` VALUES ('6', '1', '3', '这是一个评论测试用例6', '2022-04-11 20:00:03');
INSERT INTO `comment` VALUES ('7', '1', '1', '这是一个评论测试用例7', '2022-04-11 20:00:22');
INSERT INTO `comment` VALUES ('9', '1', '1', '哇偶', '2022-04-20 23:37:00');
INSERT INTO `comment` VALUES ('10', '27', '1', '哇偶', '2022-04-22 20:37:11');
INSERT INTO `comment` VALUES ('11', '27', '1', '测试一下', '2022-04-22 20:38:12');
INSERT INTO `comment` VALUES ('12', '2', '2', '啊对对对', '2022-04-22 20:56:07');
INSERT INTO `comment` VALUES ('13', '2', '1', '啊对对对', '2022-04-22 21:05:44');
INSERT INTO `comment` VALUES ('14', '27', '2', '好耶', '2022-05-05 14:54:15');
INSERT INTO `comment` VALUES ('15', '27', '2', '先有老菊后有天', '2022-05-05 14:55:52');
INSERT INTO `comment` VALUES ('16', '28', '12', '评论测试', '2022-05-27 13:41:29');
INSERT INTO `comment` VALUES ('18', '13', '13', '测试评论', '2022-05-27 14:30:29');
INSERT INTO `comment` VALUES ('20', '28', '1', '哇偶', '2023-03-10 10:39:35');
INSERT INTO `comment` VALUES ('21', '26', '1', '老婆！', '2023-03-10 10:39:56');
INSERT INTO `comment` VALUES ('22', '26', '6', '老婆！', '2023-03-10 10:40:25');
INSERT INTO `comment` VALUES ('23', '32', '6', '确实', '2023-03-10 10:53:00');
INSERT INTO `comment` VALUES ('24', '32', '1', '确实', '2023-03-10 10:53:15');
INSERT INTO `comment` VALUES ('25', '11', '1', '哇偶', '2023-03-21 21:50:03');

-- ----------------------------
-- Table structure for friends
-- ----------------------------
DROP TABLE IF EXISTS `friends`;
CREATE TABLE `friends` (
  `friendsId` int(11) NOT NULL AUTO_INCREMENT,
  `friendsUserId` int(11) NOT NULL,
  `friendsFollowedId` int(11) NOT NULL,
  PRIMARY KEY (`friendsId`),
  KEY `friendsUserId` (`friendsUserId`),
  KEY `friendsFollowId` (`friendsFollowedId`),
  CONSTRAINT `friends_ibfk_1` FOREIGN KEY (`friendsUserId`) REFERENCES `user` (`userId`),
  CONSTRAINT `friends_ibfk_2` FOREIGN KEY (`friendsFollowedId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of friends
-- ----------------------------
INSERT INTO `friends` VALUES ('2', '1', '3');
INSERT INTO `friends` VALUES ('3', '4', '1');
INSERT INTO `friends` VALUES ('4', '1', '5');
INSERT INTO `friends` VALUES ('5', '1', '4');
INSERT INTO `friends` VALUES ('6', '2', '1');
INSERT INTO `friends` VALUES ('8', '7', '1');
INSERT INTO `friends` VALUES ('9', '1', '2');
INSERT INTO `friends` VALUES ('11', '13', '3');
INSERT INTO `friends` VALUES ('13', '13', '1');
INSERT INTO `friends` VALUES ('14', '13', '2');
INSERT INTO `friends` VALUES ('15', '6', '1');
INSERT INTO `friends` VALUES ('16', '1', '6');

-- ----------------------------
-- Table structure for label
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label` (
  `labelId` int(11) NOT NULL AUTO_INCREMENT,
  `labelName` varchar(16) NOT NULL,
  PRIMARY KEY (`labelId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of label
-- ----------------------------

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `noticeId` int(11) NOT NULL AUTO_INCREMENT,
  `noticeTitle` varchar(16) NOT NULL,
  `noticeAdminId` int(11) NOT NULL,
  `noticeCreateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `noticeHits` int(11) NOT NULL DEFAULT '1',
  `noticeLongContent` longtext,
  PRIMARY KEY (`noticeId`),
  KEY `noticeAdminId` (`noticeAdminId`),
  CONSTRAINT `notice_ibfk_1` FOREIGN KEY (`noticeAdminId`) REFERENCES `admin` (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('1', 'SOULJourney开始更新了', '1', '2022-04-23 00:15:10', '4', 'SOULJourney开始更新了');
INSERT INTO `notice` VALUES ('2', 'SOULJourney的使用手册', '1', '2022-04-23 00:15:22', '8', 'SOULJourney的使用手册\r\n（1）	上传视频需知：\r\n目前仅支持转载B站视频，点击B站视频的分享按钮，选择嵌入代码式分享。\r\niframe标签中有 src属性=\"……\"\r\n将代码中的src部分选取出并粘贴到发布栏即可实现转载。\r\n');
INSERT INTO `notice` VALUES ('3', '公告测试用例1', '1', '2022-04-23 00:21:55', '1', '公告测试用例1');
INSERT INTO `notice` VALUES ('4', '公告测试用例2', '1', '2022-04-23 00:22:07', '1', '公告测试用例2');
INSERT INTO `notice` VALUES ('5', '公告测试用例3', '1', '2022-04-23 00:22:16', '1', '公告测试用例3');
INSERT INTO `notice` VALUES ('6', '公告测试用例4', '1', '2022-04-23 00:22:24', '1', '公告测试用例4');
INSERT INTO `notice` VALUES ('7', '公告测试用例5', '1', '2022-04-23 00:38:14', '1', '公告测试用例5');
INSERT INTO `notice` VALUES ('8', '公告测试用例6', '1', '2022-04-23 00:38:30', '1', '公告测试用例6');
INSERT INTO `notice` VALUES ('9', '公告测试用例7', '1', '2022-04-23 01:10:37', '1', '公告测试用例7');
INSERT INTO `notice` VALUES ('10', '公告测试用例8', '1', '2022-04-23 01:10:44', '1', '公告测试用例8');
INSERT INTO `notice` VALUES ('11', '公告测试用例9', '1', '2022-04-23 01:10:56', '1', '公告测试用例9');
INSERT INTO `notice` VALUES ('12', '公告测试用例10', '2', '2022-04-26 19:55:53', '2', '公告测试用例101');

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `postId` int(11) NOT NULL AUTO_INCREMENT,
  `postTitle` varchar(16) NOT NULL,
  `postUserId` int(11) NOT NULL,
  `postCreateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `postHits` int(11) NOT NULL DEFAULT '1',
  `postType` int(11) NOT NULL DEFAULT '0',
  `postContent` longtext,
  `postChat` varchar(255) DEFAULT NULL,
  `postImage` varchar(255) DEFAULT NULL,
  `postVideo` varchar(255) DEFAULT NULL,
  `postState` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`postId`),
  KEY `postUserId` (`postUserId`),
  CONSTRAINT `post_ibfk_1` FOREIGN KEY (`postUserId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('1', '最初之火与火之时代', '1', '2022-04-08 20:54:22', '14', '0', '在遥远的上古时代，世界还是未分化的状态，而这只有灰色的岩石和参天的巨树的世界里的一切都笼罩在一片大雾之中。\r\n\r\n不朽的古龙，是上古世界的霸者。他们有着岩石般的鳞片与近乎永恒的不朽生命，无人知晓古龙统治的上古世界经过了多少岁月。但这一切，随着最初之火的出现而走向终结，世界也因此迎来新的时代……\r\n\r\n不知何时，在大雾笼罩的世界中诞生了“最初之火”。火给世界带来了分化与差异。有温暖，就有寒冷；有生命，就有死亡；同样的，有光明，就有黑暗。\r\n\r\n而在黑暗中，诞生了新的存在。他们受到了火的吸引，并在火之中得到了王之灵魂。\r\n\r\n他们是：\r\n\r\n最初的死者，尼特\r\n\r\n伊萨里斯的魔女与混沌的女儿们\r\n\r\n太阳光之王葛温和他的骑士们\r\n\r\n以及，被遗忘的小人……\r\n\r\n他们得到了王之力量，挑起了与支配者古龙们的战争。\r\n\r\n葛温的雷电贯穿了石之鳞；魔女的火焰成为风暴；尼特释放出死之瘴气……\r\n\r\n而随着无鳞的白龙——希斯的背叛，古龙终于被击败了。\r\n\r\n从此，世界迎来了火之时代。\r\n\r\n而那个获得第四个王之魂的小人，没人知道他获得了怎样的力量，仿佛不曾存在过一样被彻底的遗忘了。\r\n\r\n但就像上古时代与不朽的古龙也会迎来终结一样，火终有熄灭之日，而到了那时，留下的将只有黑暗……', '', null, null, '1');
INSERT INTO `post` VALUES ('2', '闲聊贴测试用例1', '1', '2022-04-08 20:58:36', '4', '1', '', '这是一个闲聊测试用例', null, null, '1');
INSERT INTO `post` VALUES ('3', '绘画贴测试用例', '1', '2022-04-08 21:01:05', '3', '2', '反正就是展示一下子的说法', null, '/souljourney_war_exploded/static/image/registerBackground.jpg', null, '1');
INSERT INTO `post` VALUES ('4', '不死人与亡者', '1', '2022-04-10 15:22:50', '2', '0', '将世界带入新时代的火并非永恒，随着最初之火临近熄灭，光芒无法再照耀人间，夜晚无止境的持续。在人群之中，一种不死的诅咒开始蔓延。被诅咒之人身体上会显现一种被称作“黑暗之环”的刻印，而被诅咒之人，被称为“不死人”。\r\n\r\n正如其名，不死人无法死去，他们会逐渐的失去记忆与理性，最终结局是成为失去理智，只剩下对“灵魂”的渴求的行尸走肉——亡者。\r\n\r\n没人知道这诅咒从何而来，也没人知道如何才能解开诅咒。所以，不死人全部都被抓捕之后送往北方，并投入监牢。对于不会死去的不死人来说，刑期，则等同于永恒……\r\n\r\n据说被选中的不死人需要前往众神之地罗德兰完成被称为“不死人朝圣”的宿命和任务，所以有很多人出于各种各样的原因自愿成为不死人。而第一名为完成某种任务而被创造的不死人相传是来自白教，但到底是为了什么目的就只有白教内的部分人才能知道了。\r\n\r\n不死人还与篝火有着紧密的联系，对于被祖国抛弃的不死人，可以给不死人带来修整与片刻安宁的篝火就成了不死人新的也是永恒的故乡。', null, null, null, '1');
INSERT INTO `post` VALUES ('5', '闲聊测试用例2', '1', '2022-04-11 20:01:52', '3', '1', '', '这是一个闲聊测试用例2', null, null, '1');
INSERT INTO `post` VALUES ('7', '闲聊测试用例4', '1', '2022-04-13 22:13:09', '5', '1', '', '这是一个闲聊测试用例4', null, null, '1');
INSERT INTO `post` VALUES ('8', '篝火与灵魂', '1', '2022-04-15 19:35:00', '2', '0', '篝火\r\n\r\n存在于游戏各地的篝火，被认为来自于最初之火，所以并不会轻易熄灭。不死人可以在篝火处获得恢复并可通过在篝火处通过灵魂来增强自身能力。\r\n\r\n一些篝火还有着人型的化身——“火防女”，火防女与其对应的篝火具有某种共生关系。如果火防女死亡，与其对应的篝火亦将熄灭。火防女也被称为“人性”的容器，所以其身体的内在被认为是“扭曲污秽”的。拥有火防女的篝火与篝火之间、篝火与最初之火之间，依然存在着某种联系，具有某种资格的不死人可以在这些篝火之间进行传送。\r\n\r\n灵魂\r\n\r\n被称为生命之源，与“最初之火”一同诞生。获得其中最强大的“王之魂”的葛温等人，战胜古龙开创了新时代。他们也成为了新生的“火之时代”的王者，被奉为神一般的存在。\r\n\r\n不死人本能的渴求灵魂，甚至变成失去所有记忆和理性的亡者后，依然会被这种欲望所驱使，永远的追逐着灵魂。又或者，正是因为对灵魂渴求的觉醒才使人成为不死人这种说法才更贴切也说不定。\r\n\r\n在游戏中，灵魂既是力量，可以用来提升自身能力；也是类似于货币一样的存在，可以用来与人交易，获取装备、道具、法术甚至仅仅是情报。', null, null, null, '1');
INSERT INTO `post` VALUES ('9', '人性与人像', '2', '2022-04-15 19:52:32', '1', '0', '人性\r\n\r\n1代中的道具。\r\n\r\n外观为一种黑色的精石，可以作为道具使用来使不死人获得人性，而不死人可以通过消耗体内的人性使已经显露亡者之相的自己的外表恢复成人型；也可以投入篝火中来“注火”以增强火势。甚至在一些誓约中可以通过献上人性来提高誓约的强度。但是关于这叫做”人性“的小小黑晶究竟为何物还是个迷。“如果说灵魂是生命之源，那只有人才具有的人性又是何物呢？“\r\n\r\n人像\r\n\r\n2代中的道具。\r\n\r\n温暖、柔软，有着像影子一样暗淡色泽的塑像。如果一直盯着它看的话，会发现人的样子浮现出来，但每个人看到的都是不一样的。\r\n\r\n不死人可以通过使用它从亡者变回生者的模样。也可以投入篝火之中，使得短时间内与其他世界的联系变得微弱，限制灵体的入侵与协作。\r\n\r\n基本上可以认为是与前作的“人性”具有相同的功能，不过本作没有保存于体内的人性，也不再需要在篝火处才能恢复生者模样，直接使用人像即可。至于人性与人像的关系游戏中并没有明确给出\r\n\r\n玩家第一次得到人像是在一线天森林中迷之老妇人赠送的，同时她会说玩家在人像中看到的是自己，所以所谓每个人看到的人像都不一样应该就是指从人像中会看到自己的模样。', null, null, null, '1');
INSERT INTO `post` VALUES ('10', '法术', '2', '2022-04-15 19:52:56', '2', '0', '魔法\r\n\r\n\r\n被认为由无鳞的白龙——希斯所创。通过驱使灵魂之力来发动，魔法的强弱取决于使用者自身的法力（智力）。在普通的灵魂魔法之上还有更高级的结晶灵魂魔法，据说还有很多更强大的魔法但已经失传。而这些魔法被创造的目的并不为人所知。\r\n\r\n在人类中流传的魔法早期并非是以战斗为目的的灵魂法术，多是些近乎“恶作剧”的小手段。但不知从何时起，魔法和魔法师也和骑士与战士一样成为了国家战斗力的一部分。这也使得魔法更加向着直接攻击敌人的方向发展。\r\n\r\n1代中人类法师多出自彼海姆，那里也有着最著名的魔法学府：龙学院。而有迹象暗示2代的游戏舞台多兰古雷格正是多年之后的彼海姆所在大陆，因此已知历史中的国家很多都是魔法强国。\r\n\r\n咒术\r\n\r\n\r\n咒术是一种操控火焰的强大法术。在人类中流传的咒术被认为发源于大沼，但其实咒术是由混沌女儿之一的克拉娜所创，被称为“咒术王”的扎拉曼正是克拉娜的弟子，之后他返回大沼传授技法，才有了如今人世间流传的咒术。\r\n\r\n咒术的力量来自于使用者自身的灵魂，所以与魔法不同，咒术的强弱完全由作为触媒而被使用者培养修炼的“咒术之火”来决定，而提升咒术之火的强度则需要灵魂，所以其实咒术的强弱就是取决于使用者的灵魂的强弱。\r\n\r\n因为发源自拥有“王之魂”力量的混沌魔女，咒术有着与最初之火一般，象征着大自然本源的强大力量。也因此也被认为野蛮和危险使得咒术的使用者在人类中受到排斥。\r\n\r\n奇迹\r\n\r\n\r\n与依靠灵魂力量的法术和咒术不同，奇迹完全凭借使用者的信仰之力驱动。奇迹是“神”的事迹的再现，通过圣物作为触媒，将曾经的“神迹”再次召唤于人世间成为使用者的力量。越是强大的奇迹就越要求使用者拥有虔诚的信仰，有些奇迹甚至要以缔结某种契约为前提才能显灵。但这些“神迹”是否真的发生过，作为人类就无法知晓了。\r\n\r\n圣职者为奇迹的主要使用者，但能使用奇迹的人却并不限于此。奇迹的种类和效果比以面向战斗为主的灵魂魔法和咒术要更丰富，但直接作战的效果就要逊色不少。不过奇迹之中也不乏像“雷枪”这样强大的杀伤性法术。\r\n\r\n暗术\r\n\r\n\r\n于2代中首次登场的法术类型，相传由暗术之祖基利亚根据古代魔法所创，被认为是魔法或者奇迹的另一种形态。根据种类的不同一部分通过魔法触媒发动；而另一部分则需要使用奇迹触媒。但暗术同时也被认为是由“扭曲生命之理”而产生的法术，所以被大多数国家列为禁忌。\r\n\r\n据说基利亚虽创造了暗术，但他一生没有收过一个弟子，所以暗术如何流传至今依然是个迷。又或者说，如今流传的暗术其实是从别的地方诞生的也未可知。比如玩家在游戏中遇到的“逐出师门的菲尔金”，他所使用和教授的暗术都是自己参悟开发的。所以关于暗术还有着很多未解谜团。', null, null, null, '1');
INSERT INTO `post` VALUES ('11', '罗德兰', '2', '2022-04-15 19:53:09', '3', '0', '1代的游戏舞台。\r\n\r\n罗德兰曾经是众神的居所，但在游戏中是包括太阳王葛温在内都已不再的失落之地。被选中的不死人都会或主动或被动的为完成名为“朝圣”的使命被聚集而来。\r\n\r\n虽然众神已经不在，但曾经经历过古龙战争的其他“王之魂”获得者以及白龙西斯等伟大存在也盘踞于这块古老的土地上。\r\n\r\n罗德兰的时间处于不会流逝的状态，不同的时间与空间会在此处发生交错，因此经常会在这里见到一些本不应同时存在的人和物。在这样的罗德兰，不死人可以通过特殊的“蜡石”将文字和影像传递给处于其他时间或空间的朝圣者；甚至还可以作为“灵体”进入他们的世界提供帮助或者抢夺人性。\r\n\r\n关于“灵体”的设定是仅仅为了游戏的联机模式还是与游戏的剧情有着某种联系目前还存在一些争议。', null, null, null, '1');
INSERT INTO `post` VALUES ('12', '多兰古雷格', '2', '2022-04-15 19:53:20', '5', '0', '2代的游戏舞台。\r\n\r\n很久以前，在遥远的北方、高墙之外，由伟大的王汎克拉德建立的古代王国。从一些迹象和遗留下来的信息来看，这里极有可能曾是前作中拥有龙学院的魔法国度彼海姆的所在之地。\r\n\r\n多兰古雷格有着已经众多已经逝去的神明留下的痕迹，迄今为止也有着数不清的王国在此兴盛又覆灭。如今的多兰古雷格也已经是一片荒废之景。\r\n\r\n据说在这里，有着可以唤回人类理性的被称为“灵魂”的力量，因此显现了“暗之刻印”成为了不死人的的主人公或许是为了解开诅咒；又或许是被对灵魂的欲望所驱使，穿过“腐朽尽头之门”来到此地开始了自己的旅程，“就像被光吸引的飞虫一样”。\r\n\r\n在2代中依然存在灵体进入其他世界的联机系统设定，但游戏并没有给出世界观上的解释。', null, null, null, '1');
INSERT INTO `post` VALUES ('13', '职业', '1', '2022-04-15 19:53:36', '11', '0', '1代在游戏开始时需要选择主人公的职业，即出身。2代是在一线天森林见到迷之老妇人之后选择。1代共有10种初始职业可以选择，2代有8种。\r\n\r\n战士：\r\n\r\n以战斗为职业的战士，力量与敏捷都很高，同时也是使用武器的专家，但初始时和魔法相关的属性整体都很低。\r\n\r\n骑士：\r\n\r\n低阶骑士。拥有最高的初始体力和防御很高的护甲，但是防具较重也成为缺点。1代中该职业从最初就结下了“白教”的契约。\r\n\r\n剑士：\r\n\r\n在2代中加入的职业，磨炼技巧的剑士，双持武器，以华丽的方式战斗。\r\n\r\n流浪者：\r\n\r\n一直进行着漫无目的的旅行的轻装战士。初始就有较高敏捷，使用擅长连续攻击的曲刀，是娴熟的剑士。\r\n\r\n盗贼：\r\n\r\n行动隐秘的盗贼。虽然拥有最高的敏捷，但是初始的体力，力量，持久力都很低。使用”盗贼的短刀“给予敌人致命一击。\r\n\r\n魔法师：\r\n\r\n彼海姆学院的魔法师。初始就配有法杖和可以使用法术“灵魂之箭”，初始的记忆力和智力较高。防御系的属性整体很弱，武器也只有短剑所以不善近战。\r\n\r\n山贼：\r\n\r\n作风野蛮的山贼。初始的力量和持久力最高，因为一开始就拥有“手斧“，所以在攻击面上毫不逊色。和战士最大的不同就是他的敏捷很低。\r\n\r\n猎人：\r\n\r\n使用”短弓”擅长远距离攻击的猎人。初始敏捷很高，和同样是敏捷类的流浪者及盗贼不同，他的缺点是魔法系的属性较低。\r\n\r\n咒术师：\r\n\r\n操纵火焰的咒术师。通过使用“咒术之火”这种特殊的触媒来释放咒术，同时配有手斧所以近战实力亦不俗。\r\n\r\n圣职者：\r\n\r\n拥有初始最高的信仰，一开始就拥有奇迹”回复“，近战武器配有“矛锤”。\r\n\r\n探索者\r\n\r\n2代中首次出现的职业，巡回各地的探索者，虽然没有特别擅长的能力但是携带有很多道具。\r\n\r\n一无所有：\r\n\r\n初始级别最低，并且所有能力都是平均分配，没有任何防具，手持的棍棒和木板就是其所拥有的所有装备了。', null, null, null, '1');
INSERT INTO `post` VALUES ('14', '二号文章测试用例6', '2', '2022-04-15 19:53:51', '1', '0', '长文本测试二号机111111111111111111111111111111111111111111222222222222222222222222222222\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333', null, null, null, '1');
INSERT INTO `post` VALUES ('15', '二号文章测试用例7', '2', '2022-04-15 19:54:04', '2', '0', '长文本测试二号机111111111111111111111111111111111111111111222222222222222222222222222222\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333', null, null, null, '1');
INSERT INTO `post` VALUES ('16', '二号文章测试用例8', '2', '2022-04-15 19:54:31', '1', '0', '长文本测试二号机111111111111111111111111111111111111111111222222222222222222222222222222\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n3333333333333333333333333333333333333\n32131231314141333333n32131231314141333333n32131231314141333333', null, null, null, '1');
INSERT INTO `post` VALUES ('18', '二号文章测试用例10', '3', '2022-04-15 19:55:40', '2', '0', '长文本测试二号机111111111111111111111111111111111111111111222222222222222222222222222222\n3333333333333333333333333333333333333n32131231314141333333n32131231314141333333n32131231314141333333n32131231314141231314141333333\n32131231314141333333n321312\n32131231314141333333n321312\n32131231314141333333n321312\n32131231314141333333n321312\n32131231314141333333n321312\n32131231314141333333n321312', null, null, null, '1');
INSERT INTO `post` VALUES ('19', '二号文章测试用例11', '3', '2022-04-15 19:55:58', '11', '0', '长文本测试二号机111111111111111111111111111111111111111111222222222222222222222222222222\n3333333333333333333333333333333333333n32131231314141333333n32131231314141333333n32131231314141333333n32131231314141231314141333333\n32131231314141333333n321312\n32131231314141333333n321312\n32131231314141333333n321312\n32131231314141333333n321312\n32131231314141333333n321312\n32131231314141333333n321312\n32131231314141333333n321312\n32131231314141333333n321312\n32131231314141333333n321312\n32131231314141333333n321312\n32131231314141333333n321312\n32131231314141333333n321312', null, null, null, '1');
INSERT INTO `post` VALUES ('20', '二号文章测试用例12', '3', '2022-04-15 19:56:19', '1', '0', '长文本测试二号机111111111111111111111111111111111111111111222222222222222222222222222222\n3333333333333333333333333333333333333n32131231314141333333n32131231314141333333n32131231314141333333n32131231314141231314141333333\n32131231314141333333n321312\n32131231314141333333n321312\n32131231314141333333n321312\n32131231314141333333n321312\n32131231314141333333n321312\n32131231314141333333n321312\n32131231314141333333n321312\n32131231314141333333n321312\n32131231314141333333n321312', null, null, null, '0');
INSERT INTO `post` VALUES ('21', '文章发布测试用例1', '1', '2022-04-17 20:45:57', '2', '0', '文章发布测试用例1文章发布测试用例1文章发布测试用例1文章发布测试用例1文章发布测试用例1文章发布测试用例1', null, null, null, '0');
INSERT INTO `post` VALUES ('25', '黑魂一代手机壁纸', '1', '2022-04-21 19:28:01', '4', '2', '黑魂一代手机壁纸', null, 'static/resource/c0ba45b9-1463-448f-bbc6-2ffb0d8523e8.jpg', null, '1');
INSERT INTO `post` VALUES ('26', '梅琳娜', '1', '2022-04-21 19:33:27', '10', '2', '梅琳娜yyds', null, 'static/resource/1a599c3f-b78f-49b0-b03f-fec5be07f057.jpg', null, '1');
INSERT INTO `post` VALUES ('27', '[转载][王老菊]艾尔登法环01', '1', '2022-04-22 20:26:44', '4', '3', '[王老菊]艾尔登法环01', null, null, '//player.bilibili.com/player.html?aid=979361822', '1');
INSERT INTO `post` VALUES ('28', '帖子审核测试', '1', '2022-05-15 10:19:26', '12', '0', '帖子审核测试11111111111', null, null, null, '1');
INSERT INTO `post` VALUES ('31', '帖子审核测试123', '13', '2022-05-27 14:36:23', '1', '0', '帖子审核测试12345', null, null, null, '0');
INSERT INTO `post` VALUES ('32', '我就想说我真帅', '6', '2023-03-10 10:41:40', '5', '1', null, '我就想说我真帅，谁赞成？谁反对！', null, null, '1');

-- ----------------------------
-- Table structure for post_label
-- ----------------------------
DROP TABLE IF EXISTS `post_label`;
CREATE TABLE `post_label` (
  `plId` int(11) NOT NULL AUTO_INCREMENT,
  `plPostId` int(11) NOT NULL,
  `plLabelId` int(11) NOT NULL,
  PRIMARY KEY (`plId`),
  KEY `plPostId` (`plPostId`),
  KEY `plLabelId` (`plLabelId`),
  CONSTRAINT `post_label_ibfk_1` FOREIGN KEY (`plPostId`) REFERENCES `post` (`postId`),
  CONSTRAINT `post_label_ibfk_2` FOREIGN KEY (`plLabelId`) REFERENCES `label` (`labelId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post_label
-- ----------------------------

-- ----------------------------
-- Table structure for post_message
-- ----------------------------
DROP TABLE IF EXISTS `post_message`;
CREATE TABLE `post_message` (
  `pmId` int(11) NOT NULL AUTO_INCREMENT,
  `pmUserId` int(11) NOT NULL,
  `pmPostId` int(11) NOT NULL,
  `pmPostState` int(11) NOT NULL,
  PRIMARY KEY (`pmId`),
  KEY `pmPostId` (`pmPostId`),
  CONSTRAINT `post_message_ibfk_1` FOREIGN KEY (`pmPostId`) REFERENCES `post` (`postId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post_message
-- ----------------------------
INSERT INTO `post_message` VALUES ('6', '3', '20', '0');
INSERT INTO `post_message` VALUES ('7', '3', '20', '1');
INSERT INTO `post_message` VALUES ('8', '3', '20', '0');

-- ----------------------------
-- Table structure for rights
-- ----------------------------
DROP TABLE IF EXISTS `rights`;
CREATE TABLE `rights` (
  `rightsId` int(11) NOT NULL AUTO_INCREMENT,
  `rightsAdminId` int(11) NOT NULL,
  `rightsNotice` int(1) NOT NULL DEFAULT '1',
  `rightsPost` int(1) NOT NULL DEFAULT '1',
  `rightsUser` int(1) NOT NULL DEFAULT '1',
  `rightsBest` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`rightsId`),
  KEY `rightsAdminId` (`rightsAdminId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rights
-- ----------------------------
INSERT INTO `rights` VALUES ('1', '1', '1', '1', '1', '1');
INSERT INTO `rights` VALUES ('2', '2', '1', '1', '1', '0');
INSERT INTO `rights` VALUES ('3', '3', '1', '1', '1', '0');
INSERT INTO `rights` VALUES ('4', '4', '1', '1', '1', '0');
INSERT INTO `rights` VALUES ('5', '5', '1', '1', '1', '0');
INSERT INTO `rights` VALUES ('6', '6', '1', '1', '1', '0');
INSERT INTO `rights` VALUES ('7', '7', '1', '1', '1', '0');
INSERT INTO `rights` VALUES ('8', '8', '1', '1', '1', '0');
INSERT INTO `rights` VALUES ('10', '12', '1', '1', '1', '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userUid` varchar(16) NOT NULL,
  `userPassword` varchar(16) NOT NULL,
  `userName` varchar(8) NOT NULL,
  `userEmail` varchar(30) NOT NULL,
  `userCreateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `userAvatar` varchar(255) DEFAULT NULL,
  `userState` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '123', '123', '初始的火种', '123@qq.com', '2022-03-25 17:41:22', 'static/resource/7554106c-8bb4-4118-9b55-5a5992ab5ea6.JPG', '1');
INSERT INTO `user` VALUES ('2', 'a', 'a', '初心者1', 'a@qq.com', '2022-03-30 13:44:44', 'static/resource/4fb279bb-2787-41ef-b78c-0433a8964991.JPG', '1');
INSERT INTO `user` VALUES ('3', '1234', '1234', '初心者2', '1234@qq.com', '2022-03-30 13:49:27', 'static/resource/3a13f34b-ca1a-4fd3-912a-5018df6ea25b.jpg', '1');
INSERT INTO `user` VALUES ('4', 'email', '123456', '邮箱测试用例1', 'email@qq.com', '2022-04-03 00:34:14', 'static/resource/3a13f34b-ca1a-4fd3-912a-5018df6ea25b.jpg', '1');
INSERT INTO `user` VALUES ('5', 'abc', '123456', '注册测试用例1', '2592039887@qq.com', '2022-04-03 00:48:48', 'static/resource/3a13f34b-ca1a-4fd3-912a-5018df6ea25b.jpg', '1');
INSERT INTO `user` VALUES ('6', '1', '1', '1', '1@qq.com', '2022-04-18 10:18:02', 'static/resource/3a13f34b-ca1a-4fd3-912a-5018df6ea25b.jpg', '1');
INSERT INTO `user` VALUES ('7', '12', '12', '12', '12@qq.com', '2022-04-18 10:18:53', 'static/resource/3a13f34b-ca1a-4fd3-912a-5018df6ea25b.jpg', '0');
INSERT INTO `user` VALUES ('8', 'ab', 'ab', 'ab', '2592039887@qq.com', '2022-04-18 10:21:07', 'static/resource/434fb801-9ee1-43d5-940a-9b921e7a48b3.jpg', '1');
INSERT INTO `user` VALUES ('9', '12345', '12345', '12345', '12345@qq.com', '2022-05-08 14:48:46', 'static/resource/3a13f34b-ca1a-4fd3-912a-5018df6ea25b.jpg', '1');
INSERT INTO `user` VALUES ('10', 'abcd', 'abcd', 'abcd', 'abcd@qq.com', '2022-05-08 16:42:26', 'static/resource/3a13f34b-ca1a-4fd3-912a-5018df6ea25b.jpg', '0');
INSERT INTO `user` VALUES ('11', 'abcde', 'abcde', 'abcde', 'abcde@qq.com', '2022-05-15 09:33:46', 'static/resource/3a13f34b-ca1a-4fd3-912a-5018df6ea25b.jpg', '1');
INSERT INTO `user` VALUES ('12', '810937', '12345', '810937', '810937@qq.com', '2022-05-27 13:38:55', 'static/resource/4bef1947-0cef-4978-b11e-88b747c2fdbf.JPG', '1');
INSERT INTO `user` VALUES ('13', '2592039887', '123456', 'pc', '2592039887@qq.com', '2022-05-27 14:19:12', 'static/resource/ddb4893d-cb4d-4ea2-a8e5-e86a5edf8cd7.JPG', '1');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_infoId` int(11) NOT NULL AUTO_INCREMENT,
  `user_infoUserId` int(11) NOT NULL,
  `user_infoSex` int(1) DEFAULT '0',
  `user_infoIntroduce` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_infoId`),
  KEY `user_infoUserId` (`user_infoUserId`),
  CONSTRAINT `user_info_ibfk_1` FOREIGN KEY (`user_infoUserId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
