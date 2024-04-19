<!-- 首页 -->
<template>
	<view>
		<cu-custom bgColor="bg-gradual-blue" :isBack="false">
			<block slot="content">首页</block>
		</cu-custom>
		<view class='nav-list margin-top'>
			<navigator @click="menuClick(item)" open-type="navigate" :url="'/tn_components/' + item.title"
				:class="'nav-li bg-menu' + (index+1)" v-for="(item, index) in menuList" :key="index">
				<view class="nav-name">{{item.name}}</view>
			</navigator>
		</view>
	</view>
</template>

<script>
	import request from '@/common/request.js';
	export default {
		data() {
			return {
				menuList: [
					{
						title: 'userCenter',
						name: '个人中心',
						color: ''
					},
					{
						title: 'dietManage',
						name: '饮食管理',
						color: ''
					},
					{
						title: 'sportsManage',
						name: '运动管理',
						color: ''
					},
					{
						title: 'peManage',
						name: '体检管理',
						color: ''
					}
				]
			}
		},
		
		methods: {
			menuClick(menu) {
				console.log(menu)
				uni.navigateTo({
					url:'/pages/index/' + menu.title + '/index'
				})
				// if (menu.title !== 'userCenter') {
				// 	uni.navigateTo({
				// 		url:'/pages/index/' + menu.title + '/index'
				// 	})
				// } else {
					
				// }
			}
		}
	};
</script>
<style lang="scss" scoped>
	.nav-list {
		display: flex;
		flex-wrap: wrap;
		padding: 0px 40upx 0px;
		justify-content: space-between;
	}
	
	.nav-name {
		font-size: 50upx;
		text-transform: Capitalize;
		margin-top: 20upx;
		position: relative;
	}
	
	.nav-name::before {
		content: "";
		position: absolute;
		display: block;
		width: 40upx;
		height: 6upx;
		background: #fff;
		bottom: 0;
		right: 0;
		opacity: 0.5;
	}
	
	.nav-name::after {
		content: "";
		position: absolute;
		display: block;
		width: 100upx;
		height: 1px;
		background: #fff;
		bottom: 0;
		right: 40upx;
		opacity: 0.3;
	}
	
	.nav-name::first-letter {
		font-weight: bold;
		font-size: 60upx;
		margin-right: 1px;
	}
	
	.nav-li {
		padding: 80rpx;
		border-radius: 12upx;
		width: 45%;
		margin: 0 2.5% 40upx;
		background-image: url(https://s1.ax1x.com/2020/06/27/NyU04x.png);
		background-size: cover;
		background-position: center;
		position: relative;
		z-index: 1;
	}
	
	.nav-li::after {
		content: "";
		position: absolute;
		z-index: -1;
		background-color: inherit;
		width: 100%;
		height: 100%;
		left: 0;
		bottom: -10%;
		border-radius: 10upx;
		opacity: 0.2;
		transform: scale(0.9, 0.9);
	}
	
	.nav-li.cur {
		color: #fff;
		background: rgb(94, 185, 94);
		box-shadow: 4upx 4upx 6upx rgba(94, 185, 94, 0.4);
	}
	
	.nav-li text {
		position: absolute;
		right: 30upx;
		top: 30upx;
		font-size: 52upx;
		width: 60upx;
		height: 60upx;
		text-align: center;
		line-height: 60upx;
	}
	
	/*  */
	.bg-menu1 {
		background-color: #FF5656;
		color: #fff;
	}
	
	.bg-menu2 {
		background-color: #6F68DF;
		color: #fff;
	}
	
	.bg-menu3 {
		background-color: #9c26b0;
		color: #fff;
	}
	
	.bg-menu4 {
		background-color: #0070FF;
		color: #fff;
	}
</style>
