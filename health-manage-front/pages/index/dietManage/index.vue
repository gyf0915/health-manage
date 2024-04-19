<template>
	<view style="height: 100ch;">
		<view class="swiper-item uni-bg-red">
			<image class="swiper-img radius shadow-warp" src="../../../static/dietBanner.png" mode="widthFix"></image>
		</view>
		<u-card v-for="item in dataList" :title="item.dietDate + '   ' + formatterDietType(item.dietType)" @click="doEdit(item)">
			<view slot="body">
				<view class="u-body-item u-flex u-border-bottom u-col-between u-p-t-0">
					<view style="display: inline-block;" class="u-body-item-title u-line-2">{{item.specificPlan}}</view>
					<view style="float: right;">
						<view style="display: inline-block;font-size: 20px;color: crimson;">{{item.dietHeat}}</view> 千焦
					</view>
				</view>
			</view>
		</u-card>
		<u-popup v-model="show" mode="bottom">
			<view style="padding: 20px 20px;">
				<u-form :model="form" ref="uForm" label-width="90px">
					<u-form-item label="饮食日期">
						<u-input v-model="form.dietDate" @click="openCalendar"></u-input>
					</u-form-item>
					<u-form-item label="用餐类型">
						<u-radio-group v-model="form.dietType">
							<u-radio name="breakfast">早餐</u-radio>
							<u-radio name="lunch">午餐</u-radio>
							<u-radio name="dinner">晚餐</u-radio>
						</u-radio-group>
					</u-form-item>
					<u-form-item label="具体饮食">
						<u-input v-model="form.specificPlan" ></u-input>
					</u-form-item>
					<u-form-item label="热量">
						<!-- 千卡路里 -->
						<u-input v-model="form.dietHeat" ></u-input>
					</u-form-item>
				</u-form>
				<u-button @click="doSave" style="margin-top: 15px;" type="primary">保存</u-button>
			</view>
		</u-popup>
		<view class="box" v-if="mode === 'tab'">
			<view class="cu-bar tabbar bg-white shadow foot" style="bottom: 40px;">
				<view @click="doAdd" class="action text-gray add-action">
					<image class="logo_btn" mode="widthFix" src="../../../static/jiahao.png"></image>
					<view :class="PageCur=='dietManage'?'color_main':'text-gray'">记录饮食</view>
				</view>
			</view>
		</view>
		<view class="box" v-else>
			<view class="cu-bar tabbar bg-white shadow foot">
				<view @click="doAdd" class="action text-gray add-action">
					<image class="logo_btn" mode="widthFix" src="../../../static/jiahao.png"></image>
					<view :class="PageCur=='dietManage'?'color_main':'text-gray'">记录饮食</view>
				</view>
			</view>
		</view>
		<u-calendar v-model="calendarSwitch" mode="date" @change="confirmDate"></u-calendar>
	</view>
</template>

<script>
	import request from '@/common/request.js'
	export default {
		data() {
			return {
				form: {
					id: '',
					dietDate: '',
					dietType: '',
					specificPlan: '',
					dietHeat: ''
				},
				dietTypeList: [
					{
						value: 'breakfast',
						label: '早餐'
					},
					{
						value: 'lunch',
						label: '午餐'
					},
					{
						value: 'dinner',
						label: '晚餐'
					}
				],
				calendarSwitch:false,
				show: false,
				dataList: []
			}
		},
		mounted() {
			this.getData()
		},
		props: ['mode'],
		methods: {
			getData() {
				console.log('数据加载');
				let opts = {
					url: 'diet/list',
					method: 'post'
				};
				let data = {
					loginId: 'test'
				}
				uni.showLoading({
					title: '加载中'
				});
				request.httpRequest(opts, data).then(res => {
					console.log(res);
					uni.hideLoading();
					this.dataList = res.data
				});
			},
			formatterDietType(dietType) {
				let result = ''
				this.dietTypeList.forEach(item => {
					if (item.value === dietType) {
						result = item.label
					}
				})
				return result
			},
			doAdd() {
				this.show = true
			},
			openCalendar() {
				this.calendarSwitch = true
			},
			confirmDate(e) {
				console.log(e)
				this.form.dietDate = e.result
			},
			doEdit(item) {
				this.form = item
				this.show = true
			},
			doSave() {
				
				this.form.loginId = 'test'
				if (this.form.id == '') {
					//新增
					let opts = {
						url: 'diet/insert',
						method: 'post'
					};
					request.httpRequest(opts, this.form).then(res => {
						console.log(res);
						this.show = false
						this.getData()
					});
				} else {
					//更新
					let opts = {
						url: 'diet/update',
						method: 'post'
					};
					request.httpRequest(opts, this.form).then(res => {
						console.log(res);
						this.show = false
						this.getData()
					});
				}
			}
		}
	}
</script>

<style lang="scss" scoped>
	.color_main{
		color: #000000;
		font-weight: 900;
	}
	.box {
		margin: 20upx 0;
	}
	.box view.cu-bar {
		margin-top: 20upx;
	}
	
	.logo_btn{
		width: 38*2rpx;
		height: 38*2rpx;
		position: absolute;
		z-index: 2;
		border-radius: 50%;
		top: -40rpx;
		left: 0rpx;
		right: 0;
		margin: auto;
		padding: 0;
	}
	.cu-bar.tabbar .action.add-action {
	    padding-top: 56rpx !important;
	}
</style>