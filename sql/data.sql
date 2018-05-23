USE [decision_tree_c45_db]
GO
/****** Object:  Table [dbo].[teacher_course_tb]    Script Date: 05/23/2018 19:28:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[teacher_course_tb](
	[teacher_course_id] [int] IDENTITY(1,1) NOT NULL,
	[course_id] [int] NULL,
	[teacher_account_id] [int] NULL,
	[update_date] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[teacher_course_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[teacher_course_tb] ON
INSERT [dbo].[teacher_course_tb] ([teacher_course_id], [course_id], [teacher_account_id], [update_date]) VALUES (6, 1, 4, CAST(0x0000A8E60188B066 AS DateTime))
INSERT [dbo].[teacher_course_tb] ([teacher_course_id], [course_id], [teacher_account_id], [update_date]) VALUES (7, 2, 4, CAST(0x0000A8E601890BB9 AS DateTime))
INSERT [dbo].[teacher_course_tb] ([teacher_course_id], [course_id], [teacher_account_id], [update_date]) VALUES (9, 3, 4, CAST(0x0000A8E601891122 AS DateTime))
INSERT [dbo].[teacher_course_tb] ([teacher_course_id], [course_id], [teacher_account_id], [update_date]) VALUES (10, 5, 3, CAST(0x0000A8E7017E26F1 AS DateTime))
INSERT [dbo].[teacher_course_tb] ([teacher_course_id], [course_id], [teacher_account_id], [update_date]) VALUES (11, 5, 4, CAST(0x0000A8E9013DBCA2 AS DateTime))
SET IDENTITY_INSERT [dbo].[teacher_course_tb] OFF
/****** Object:  Table [dbo].[survey_tb]    Script Date: 05/23/2018 19:28:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[survey_tb](
	[survey_id] [int] IDENTITY(1,1) NOT NULL,
	[before_class_understand] [int] NULL,
	[classroom_leaning] [int] NULL,
	[operate_computer_leaning_time] [int] NULL,
	[peacetime_score] [int] NULL,
	[student_account_id] [int] NULL,
	[teacher_course_id] [int] NULL,
	[update_date] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[survey_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[survey_tb] ON
INSERT [dbo].[survey_tb] ([survey_id], [before_class_understand], [classroom_leaning], [operate_computer_leaning_time], [peacetime_score], [student_account_id], [teacher_course_id], [update_date]) VALUES (2, 1, 1, 1, 1, 6, 9, CAST(0x0000A8E8000C9C20 AS DateTime))
INSERT [dbo].[survey_tb] ([survey_id], [before_class_understand], [classroom_leaning], [operate_computer_leaning_time], [peacetime_score], [student_account_id], [teacher_course_id], [update_date]) VALUES (3, 1, 1, 1, 1, 6, 7, CAST(0x0000A8E800E84CC0 AS DateTime))
INSERT [dbo].[survey_tb] ([survey_id], [before_class_understand], [classroom_leaning], [operate_computer_leaning_time], [peacetime_score], [student_account_id], [teacher_course_id], [update_date]) VALUES (4, 1, 2, 2, 2, 8, 9, CAST(0x0000A8E800F14BD4 AS DateTime))
INSERT [dbo].[survey_tb] ([survey_id], [before_class_understand], [classroom_leaning], [operate_computer_leaning_time], [peacetime_score], [student_account_id], [teacher_course_id], [update_date]) VALUES (5, 3, 3, 3, 3, 9, 9, CAST(0x0000A8E800F164FB AS DateTime))
INSERT [dbo].[survey_tb] ([survey_id], [before_class_understand], [classroom_leaning], [operate_computer_leaning_time], [peacetime_score], [student_account_id], [teacher_course_id], [update_date]) VALUES (6, 1, 2, 3, 2, 8, 7, CAST(0x0000A8E800F19C22 AS DateTime))
INSERT [dbo].[survey_tb] ([survey_id], [before_class_understand], [classroom_leaning], [operate_computer_leaning_time], [peacetime_score], [student_account_id], [teacher_course_id], [update_date]) VALUES (7, 3, 3, 1, 3, 9, 7, CAST(0x0000A8E800F1ACF5 AS DateTime))
INSERT [dbo].[survey_tb] ([survey_id], [before_class_understand], [classroom_leaning], [operate_computer_leaning_time], [peacetime_score], [student_account_id], [teacher_course_id], [update_date]) VALUES (8, 1, 2, 2, 2, 6, 6, CAST(0x0000A8E9013D3233 AS DateTime))
INSERT [dbo].[survey_tb] ([survey_id], [before_class_understand], [classroom_leaning], [operate_computer_leaning_time], [peacetime_score], [student_account_id], [teacher_course_id], [update_date]) VALUES (9, 1, 2, 3, 3, 8, 6, CAST(0x0000A8E9013DA5BC AS DateTime))
INSERT [dbo].[survey_tb] ([survey_id], [before_class_understand], [classroom_leaning], [operate_computer_leaning_time], [peacetime_score], [student_account_id], [teacher_course_id], [update_date]) VALUES (10, 2, 3, 2, 3, 8, 11, CAST(0x0000A8E9013DC808 AS DateTime))
INSERT [dbo].[survey_tb] ([survey_id], [before_class_understand], [classroom_leaning], [operate_computer_leaning_time], [peacetime_score], [student_account_id], [teacher_course_id], [update_date]) VALUES (11, 3, 3, 2, 3, 8, 10, CAST(0x0000A8E9013DEB06 AS DateTime))
INSERT [dbo].[survey_tb] ([survey_id], [before_class_understand], [classroom_leaning], [operate_computer_leaning_time], [peacetime_score], [student_account_id], [teacher_course_id], [update_date]) VALUES (12, 1, 2, 1, 2, 6, 10, CAST(0x0000A8E9013F227B AS DateTime))
SET IDENTITY_INSERT [dbo].[survey_tb] OFF
/****** Object:  Table [dbo].[student_class_tb]    Script Date: 05/23/2018 19:28:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[student_class_tb](
	[student_class_id] [int] IDENTITY(1,1) NOT NULL,
	[duty] [varchar](255) NULL,
	[name] [varchar](255) NULL,
	[update_date] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[student_class_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[student_class_tb] ON
INSERT [dbo].[student_class_tb] ([student_class_id], [duty], [name], [update_date]) VALUES (1, N'二年级A班', N'二年A班', CAST(0x0000A8E6017CE643 AS DateTime))
INSERT [dbo].[student_class_tb] ([student_class_id], [duty], [name], [update_date]) VALUES (2, N'三年级B班', N'三年B班', CAST(0x0000A8E6017CEEAD AS DateTime))
SET IDENTITY_INSERT [dbo].[student_class_tb] OFF
/****** Object:  Table [dbo].[score_tb]    Script Date: 05/23/2018 19:28:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[score_tb](
	[score_id] [int] IDENTITY(1,1) NOT NULL,
	[score] [float] NULL,
	[student_account_id] [int] NULL,
	[teacher_course_id] [int] NULL,
	[update_date] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[score_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[score_tb] ON
INSERT [dbo].[score_tb] ([score_id], [score], [student_account_id], [teacher_course_id], [update_date]) VALUES (3, 33, 9, 6, CAST(0x0000A8E7015C9B66 AS DateTime))
INSERT [dbo].[score_tb] ([score_id], [score], [student_account_id], [teacher_course_id], [update_date]) VALUES (4, 66, 9, 7, CAST(0x0000A8E9013BAE17 AS DateTime))
INSERT [dbo].[score_tb] ([score_id], [score], [student_account_id], [teacher_course_id], [update_date]) VALUES (6, 55, 9, 9, CAST(0x0000A8E9013BA969 AS DateTime))
INSERT [dbo].[score_tb] ([score_id], [score], [student_account_id], [teacher_course_id], [update_date]) VALUES (10, 66, 6, 10, CAST(0x0000A8E9013F4FAB AS DateTime))
INSERT [dbo].[score_tb] ([score_id], [score], [student_account_id], [teacher_course_id], [update_date]) VALUES (12, 77, 8, 10, CAST(0x0000A8E9013F3501 AS DateTime))
INSERT [dbo].[score_tb] ([score_id], [score], [student_account_id], [teacher_course_id], [update_date]) VALUES (13, 44, 8, 7, CAST(0x0000A8E9013BE37A AS DateTime))
SET IDENTITY_INSERT [dbo].[score_tb] OFF
/****** Object:  Table [dbo].[role_tb]    Script Date: 05/23/2018 19:28:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[role_tb](
	[role_id] [int] IDENTITY(1,1) NOT NULL,
	[duty] [varchar](255) NULL,
	[name] [varchar](255) NULL,
	[update_date] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[role_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[role_tb] ON
INSERT [dbo].[role_tb] ([role_id], [duty], [name], [update_date]) VALUES (1, N'超级管理员', N'超级管理员', CAST(0x0000A8E60156A386 AS DateTime))
INSERT [dbo].[role_tb] ([role_id], [duty], [name], [update_date]) VALUES (2, N'教师', N'教师', CAST(0x0000A8E60156A394 AS DateTime))
INSERT [dbo].[role_tb] ([role_id], [duty], [name], [update_date]) VALUES (3, N'学生', N'学生', CAST(0x0000A8E60156A394 AS DateTime))
SET IDENTITY_INSERT [dbo].[role_tb] OFF
/****** Object:  Table [dbo].[positional_tb]    Script Date: 05/23/2018 19:28:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[positional_tb](
	[positional_id] [int] IDENTITY(1,1) NOT NULL,
	[duty] [varchar](255) NULL,
	[name] [varchar](255) NULL,
	[update_date] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[positional_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[positional_tb] ON
INSERT [dbo].[positional_tb] ([positional_id], [duty], [name], [update_date]) VALUES (1, N'普通教师', N'讲师', CAST(0x0000A8E60165FFF9 AS DateTime))
INSERT [dbo].[positional_tb] ([positional_id], [duty], [name], [update_date]) VALUES (2, N'比讲师高一级', N'副教授', CAST(0x0000A8E601661A15 AS DateTime))
INSERT [dbo].[positional_tb] ([positional_id], [duty], [name], [update_date]) VALUES (3, N'比副教授高一级别', N'教授', CAST(0x0000A8E601662A8F AS DateTime))
SET IDENTITY_INSERT [dbo].[positional_tb] OFF
/****** Object:  Table [dbo].[major_tb]    Script Date: 05/23/2018 19:28:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[major_tb](
	[major_id] [int] IDENTITY(1,1) NOT NULL,
	[duty] [varchar](255) NULL,
	[name] [varchar](255) NULL,
	[update_date] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[major_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[major_tb] ON
INSERT [dbo].[major_tb] ([major_id], [duty], [name], [update_date]) VALUES (1, N'通信电子技术', N'通信工程', CAST(0x0000A8E60161F9B4 AS DateTime))
INSERT [dbo].[major_tb] ([major_id], [duty], [name], [update_date]) VALUES (2, N'电脑', N'计算机与科学技术', CAST(0x0000A8E6016209BB AS DateTime))
SET IDENTITY_INSERT [dbo].[major_tb] OFF
/****** Object:  Table [dbo].[data]    Script Date: 05/23/2018 19:28:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[data](
	[列 0] [varchar](50) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[course_tb]    Script Date: 05/23/2018 19:28:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[course_tb](
	[course_id] [int] IDENTITY(1,1) NOT NULL,
	[duty] [varchar](255) NULL,
	[name] [varchar](255) NULL,
	[type] [int] NULL,
	[update_date] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[course_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[course_tb] ON
INSERT [dbo].[course_tb] ([course_id], [duty], [name], [type], [update_date]) VALUES (1, N'中华中文，博大进深！', N'语文', 2, CAST(0x0000A8E70166BF54 AS DateTime))
INSERT [dbo].[course_tb] ([course_id], [duty], [name], [type], [update_date]) VALUES (2, N'逻辑', N'数学', 2, CAST(0x0000A8E70166B275 AS DateTime))
INSERT [dbo].[course_tb] ([course_id], [duty], [name], [type], [update_date]) VALUES (3, N'英文的国际化', N'英语', 2, CAST(0x0000A8E70166B911 AS DateTime))
INSERT [dbo].[course_tb] ([course_id], [duty], [name], [type], [update_date]) VALUES (4, N'政治', N'政治', 1, CAST(0x0000A8E70166CBF8 AS DateTime))
INSERT [dbo].[course_tb] ([course_id], [duty], [name], [type], [update_date]) VALUES (5, N'数据结构', N'数据结构', 3, CAST(0x0000A8E70166F75D AS DateTime))
INSERT [dbo].[course_tb] ([course_id], [duty], [name], [type], [update_date]) VALUES (6, N'历史', N'历史', 4, CAST(0x0000A8E701670594 AS DateTime))
SET IDENTITY_INSERT [dbo].[course_tb] OFF
/****** Object:  Table [dbo].[analyse_tb]    Script Date: 05/23/2018 19:28:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[analyse_tb](
	[analyse_id] [int] IDENTITY(1,1) NOT NULL,
	[business_id] [int] NULL,
	[conclusion] [varchar](255) NULL,
	[score] [float] NULL,
	[sub_type] [int] NULL,
	[type] [int] NULL,
	[update_date] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[analyse_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[analyse_tb] ON
INSERT [dbo].[analyse_tb] ([analyse_id], [business_id], [conclusion], [score], [sub_type], [type], [update_date]) VALUES (11, 6, N'您的教师课程成绩的平均分为：55.0,您的自身成绩为：55.0。
本次成绩分析中，影响您成绩的主要因素为：课后上机学习时间 （小时）！
综合评定，您本次的成绩评定为：差,不要灰心，请改变学习方法！
', 55, 1, 1, CAST(0x0000A8E9013BA97D AS DateTime))
INSERT [dbo].[analyse_tb] ([analyse_id], [business_id], [conclusion], [score], [sub_type], [type], [update_date]) VALUES (12, 4, N'您的教师课程成绩的平均分为：55.0,您的自身成绩为：66.0。
本次成绩分析中，影响您成绩的主要因素为：课堂学习！
综合评定，您本次的成绩评定为：一般,请下次再接再厉，继续保持！
', 55, 2, 1, CAST(0x0000A8E9013BAE20 AS DateTime))
INSERT [dbo].[analyse_tb] ([analyse_id], [business_id], [conclusion], [score], [sub_type], [type], [update_date]) VALUES (13, 13, N'您的教师课程成绩的平均分为：55.0,您的自身成绩为：44.0。
本次成绩分析中，影响您成绩的主要因素为：课堂学习！
综合评定，您本次的成绩评定为：差,不要灰心，请改变学习方法！
', 55, 1, 1, CAST(0x0000A8E9013BE380 AS DateTime))
INSERT [dbo].[analyse_tb] ([analyse_id], [business_id], [conclusion], [score], [sub_type], [type], [update_date]) VALUES (14, 12, N'您的教师课程成绩的平均分为：77.0,您的自身成绩为：77.0。
本次成绩分析中，由于数据过少，所以没有影响因素！
综合评定，您本次的成绩评定为：一般,请下次再接再厉，继续保持！
', 77, 2, 1, CAST(0x0000A8E9013F3505 AS DateTime))
INSERT [dbo].[analyse_tb] ([analyse_id], [business_id], [conclusion], [score], [sub_type], [type], [update_date]) VALUES (15, 10, N'您的教师课程成绩的平均分为：71.5,您的自身成绩为：66.0。
本次成绩分析中，由于数据过少，所以没有影响因素！
综合评定，您本次的成绩评定为：一般,请下次再接再厉，继续保持！
', 71.5, 2, 1, CAST(0x0000A8E9013F4FAF AS DateTime))
SET IDENTITY_INSERT [dbo].[analyse_tb] OFF
/****** Object:  Table [dbo].[account_tb]    Script Date: 05/23/2018 19:28:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[account_tb](
	[account_id] [int] IDENTITY(1,1) NOT NULL,
	[age] [int] NULL,
	[create_date] [datetime] NULL,
	[identifier] [varchar](255) NULL,
	[login_date] [datetime] NULL,
	[major_id] [int] NULL,
	[password] [varchar](255) NULL,
	[positional_id] [int] NULL,
	[realname] [varchar](255) NULL,
	[role_id] [int] NULL,
	[sex] [int] NULL,
	[student_class_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[account_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[account_tb] ON
INSERT [dbo].[account_tb] ([account_id], [age], [create_date], [identifier], [login_date], [major_id], [password], [positional_id], [realname], [role_id], [sex], [student_class_id]) VALUES (1, NULL, CAST(0x0000A8E6015719C1 AS DateTime), N'1000', CAST(0x0000A8E6015719C1 AS DateTime), NULL, N'11874bb6149dd45428da628c9766b252', NULL, N'聂跃', 1, NULL, NULL)
INSERT [dbo].[account_tb] ([account_id], [age], [create_date], [identifier], [login_date], [major_id], [password], [positional_id], [realname], [role_id], [sex], [student_class_id]) VALUES (2, 33, CAST(0x0000A8E60175D8B0 AS DateTime), N'201805202', CAST(0x0000A8E60175D8B0 AS DateTime), 0, N'11874bb6149dd45428da628c9766b252', 3, N'张一发', 2, 2, 0)
INSERT [dbo].[account_tb] ([account_id], [age], [create_date], [identifier], [login_date], [major_id], [password], [positional_id], [realname], [role_id], [sex], [student_class_id]) VALUES (3, 25, CAST(0x0000A8E6017735E8 AS DateTime), N'201805203', CAST(0x0000A8E6017735E8 AS DateTime), 0, N'11874bb6149dd45428da628c9766b252', 2, N'孙明', 2, 2, 0)
INSERT [dbo].[account_tb] ([account_id], [age], [create_date], [identifier], [login_date], [major_id], [password], [positional_id], [realname], [role_id], [sex], [student_class_id]) VALUES (4, 22, CAST(0x0000A8E6017756B8 AS DateTime), N'201805204', CAST(0x0000A8E6017756B8 AS DateTime), 0, N'11874bb6149dd45428da628c9766b252', 1, N'刘三三', 2, 2, 0)
INSERT [dbo].[account_tb] ([account_id], [age], [create_date], [identifier], [login_date], [major_id], [password], [positional_id], [realname], [role_id], [sex], [student_class_id]) VALUES (6, 22, CAST(0x0000A8E6017DD59C AS DateTime), N'201805205', CAST(0x0000A8E6017DD59C AS DateTime), 1, N'11874bb6149dd45428da628c9766b252', 0, N'张萌萌', 3, 2, 1)
INSERT [dbo].[account_tb] ([account_id], [age], [create_date], [identifier], [login_date], [major_id], [password], [positional_id], [realname], [role_id], [sex], [student_class_id]) VALUES (8, 22, CAST(0x0000A8E7012251D2 AS DateTime), N'201805216', CAST(0x0000A8E7012251D2 AS DateTime), 1, N'11874bb6149dd45428da628c9766b252', NULL, N'斯坦福', 3, 1, 1)
INSERT [dbo].[account_tb] ([account_id], [age], [create_date], [identifier], [login_date], [major_id], [password], [positional_id], [realname], [role_id], [sex], [student_class_id]) VALUES (9, 22, CAST(0x0000A8E701227F51 AS DateTime), N'201805217', CAST(0x0000A8E701227F51 AS DateTime), 1, N'11874bb6149dd45428da628c9766b252', NULL, N'辛振梅', 3, 2, 1)
SET IDENTITY_INSERT [dbo].[account_tb] OFF
