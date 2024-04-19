<template>
	<view style="height: 100ch;">
		<view class="swiper-item uni-bg-red">
			<image class="swiper-img radius shadow-warp" src="../../../static/sportBanner.png" mode="widthFix"></image>
		</view>
		<u-card v-for="item in dataList" :title="item.exerciseDate" @click="doEdit(item)">
			<view slot="body">
				<view class="u-body-item u-flex u-border-bottom u-col-between u-p-t-0">
					<u-row>
						<u-col span="2">
							<view style="display: inline-block;" class="u-body-item-title u-line-2">{{formatterExerciseType(item.exerciseType)}}</view>
						</u-col>
						<u-col span="5">
							<view>
								持续时间：<view style="display: inline-block;font-size: 15px;color: blue;">{{item.duration}}</view> 分钟
							</view>
						</u-col>
						<u-col span="5">
							<view>
								消耗：<view style="display: inline-block;font-size: 15px;color: crimson;">{{item.consumeHeat}}</view> 千焦
							</view>
						</u-col>
					</u-row>
				</view>
			</view>
		</u-card>
		
		<u-popup v-model="show" mode="bottom">
			<view style="padding: 20px 20px;">
				<u-form :model="form" ref="uForm" label-width="90px">
					<u-form-item label="运动日期">
						<u-input v-model="form.exerciseDate" @click="openCalendar"></u-input>
					</u-form-item>
					<u-form-item label="运动类型">
						<u-radio-group v-model="form.exerciseType">
							<u-radio name="running">跑步</u-radio>
							<u-radio name="cycling">骑行</u-radio>
							<u-radio name="walk">步行</u-radio>
						</u-radio-group>
					</u-form-item>
					<u-form-item label="持续时间">
						<u-number-box v-model="form.duration"></u-number-box>分钟
					</u-form-item>
					<u-form-item label="消耗热量">
						<!-- style="width: 80%" -->
						<!-- 千卡路里 -->
						<u-input v-model="form.consumeHeat" ></u-input>
					</u-form-item>
				</u-form>
				<u-button @click="doSave" style="margin-top: 15px;" type="primary">保存</u-button>
			</view>
		</u-popup>
		<view class="box" v-if="mode === 'tab'">
			<view class="cu-bar tabbar bg-white shadow foot" style="bottom: 40px;">
				<view @click="doAdd" class="action text-gray add-action">
					<image class="logo_btn" mode="widthFix" src="../../../static/jiahao.png"></image>
					<view :class="PageCur=='dietManage'?'color_main':'text-gray'">记录运动</view>
				</view>
			</view>
		</view>
		<view class="box" v-else>
			<view class="cu-bar tabbar bg-white shadow foot">
				<view @click="doAdd" class="action text-gray add-action">
					<image class="logo_btn" mode="widthFix" src="../../../static/jiahao.png"></image>
					<view :class="PageCur=='dietManage'?'color_main':'text-gray'">记录运动</view>
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
					exerciseType: '',
					exerciseDate: '',
					duration: '',
					consumeHeat: ''
				},
				exerciseTypeList: [
					{
						value: 'running',
						label: '跑步'
					},
					{
						value: 'cycling',
						label: '骑行'
					},
					{
						value: 'walk',
						label: '步行'
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
					url: 'exercise/list',
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
			formatterExerciseType(exerciseType) {
				let result = ''
				this.exerciseTypeList.forEach(item => {
					if (item.value === exerciseType) {
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
				this.form.exerciseDate = e.result
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
						url: 'exercise/insert',
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
						url: 'exercise/update',
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