USE [coin]
GO
/****** Object:  Table [dbo].[external_writer]    Script Date: 2021-12-26 오후 6:41:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[external_writer](
	[member_id] [bigint] NOT NULL,
	[external_site] [nvarchar](20) NOT NULL,
	[nick_name] [nvarchar](50) NOT NULL,
	[ins_date] [datetime] NULL,
	[upd_date] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[member]    Script Date: 2021-12-26 오후 6:41:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[member](
	[email] [varchar](50) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NULL,
	[ins_date] [datetime] NULL,
	[upd_date] [datetime] NULL,
 CONSTRAINT [PK_member] PRIMARY KEY CLUSTERED
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO