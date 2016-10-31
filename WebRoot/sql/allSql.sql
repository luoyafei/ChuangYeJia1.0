create table user (
    userId varchar(32) primary key,
    userNickName varchar(20) not null,
    userEmail varchar(30) unique,
    userPassword varchar(20) not null,
    userGender varchar(2),
    userIdCard varchar(10),
    userIntroduce varchar(255),
    userBirthday datetime,
    userCreateDate datetime default now(),
    userPhoto varchar(255),
    userAddress varchar(20),
    userIp varchar(20),
    userRealName varchar(20),
    userRealPhoto varchar(255),
    userTel varchar(20) unique,
    userWeChat varchar(20) unique,
    isVerify varchar(1) default '0', --是否认证 (0:尚未认证；1:认证成功；2:认证失败；3:正在认证)
    copartnerCategory varchar(10),   --合伙人类型（资金，技术，推广，运营，其他）
    startAbility text,				 --创业能力
    userField varchar(10),			 --领域 (移动互联网，电子商务，文化艺术，教育体育，汽车，旅游户外，房产，营销广告，硬件，工具软件，企业服务，搜索安全，医疗健康，媒体资讯，生活消费，其他)
    introduceVideo varchar(255)		 --介绍视频
) ENGINE=InnoDB default charset=utf8


create table Startups (
    startupsId varchar(32) primary key,
    startupsLeaderId varchar(32),
    startupsAccount varchar(255),
    startupsAddress varchar(50),
    startupsBrief text,
    startupsCopartnerRequire varchar(30),
    startupsCover varchar(255),
    startupsCreateDate datetime default now(),
    startupsDetail text,
    startupsName varchar(20),
    startupsOperationStage varchar(20),
    startupsPassword varchar(32),
    startupsPhoto1 varchar(255),
    startupsPhoto2 varchar(255),
    startupsPhoto3 varchar(255),
    startupsServiceType varchar(10),
    startupsVideo varchar(255),
    constraint foreign key (startupsLeaderId) references User (userId)
) ENGINE=InnoDB default charset=utf8

    
create table startups_user (
    startupsId varchar(32) not null,
    userId varchar(32) not null,
    primary key(startupsId, userId),
    constraint foreign key (startupsId) references Startups (startupsId),
    constraint foreign key (userId) references User (userId)
) ENGINE=InnoDB default charset=utf8


--申请合同
create table applyContract (
	applyId varchar(32) primary key,
	applyOrganiserId varchar(32),
	applyTitle varchar(20),
	applyContent text,
	applyStartupsId varchar(32),
	createDate datetime default now(),
	lastModifyDate datetime,
	applyStatus varchar(4),
	constraint foreign key (applyStartupsId) references Startups (StartupsId),
	constraint foreign key (applyOrganiserId) references User (userId)
)ENGINE=InnoDB default charset=utf8

--邀请合同
create table inviteContract (
	inviteId varchar(32) primary key,
	inviteOrganiserStartupsId varchar(32),
	inviteTitle varchar(20),
	inviteContent text,
	inviteUserId varchar(32), 
	createDate datetime default now(),
	lastModifyDate datetime,
	inviteStatus varchar(4),
	constraint foreign key (inviteOrganiserStartupsId) references Startups (StartupsId),
	constraint foreign key (inviteUserId) references User (userId)
)ENGINE=InnoDB default charset=utf8

--产品
create table product (
	productId varchar(32) primary key,
	productName varchar(18),
	productStartupsId varchar(32),
	productCreateDate datetime default now(),
	productPrice varchar(12),
	productBrief varchar(255),
	productDetail text,
    productAddress varchar(50),
    productCover varchar(255),
	constraint foreign key (productStartupsId) references Startups (StartupsId)
)ENGINE=InnoDB default charset=utf8

private String chatMessageId;
	private String chatMessage;
	private String fromUserId;
	private String toUserId;
	private String toChatRoomId = "0";//默认的聊天室是没有的0
	private Timestamp messageSendTime;
	private int needRead = 0;

--聊天消息
create table chatMessage (
	chatMessageId varchar(32) primary key,
	chatMessage varchar(2048),
    fromUserId varchar(32),
    toUserId varchar(32),
    messageSendTime datetime DEFAULT now(),
    needRead int(11) DEFAULT 0,
  	toChatRoomId varchar(32) default "0",
  	constraint foreign key (fromUserId) references user(userId),
  	constraint foreign key (toUserId) references user(userId)
)ENGINE=InnoDB default charset=utf8

--聊天室
create table chatRoom (
	chatRoomId varchar(32) primary key,
  	chatRoomName varchar(20),
	chatRoomCreateDate datetime DEFAULT now(),
   	creatorId varchar(32),
   	constraint foreign key (creatorId) references user(userId)
)ENGINE=InnoDB default charset=utf8
--记录
create table record_invite (
	id int primary key auto_increment,
	ip varchar(20),
	fromUrl varchar(255)
)ENGINE=InnoDB default charset=utf8
--线下交谈
create table downLineChat (
	id int primary key auto_increment,
	fromUserId varchar(32) not null,
	toUserId varchar(32),
	fromUserTel int,
	toUserTel int,
	createDate datetime default current_timestamp,
	constraint foreign key (fromUserId) references user(userId),
	constraint foreign key (toUserId) references user(userId)
)ENGINE=InnoDB default charset=utf8