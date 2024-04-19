<template>
	<view style="height: 100ch;">
		<view class="swiper-item uni-bg-red">
			<image class="swiper-img radius shadow-warp" src="../../../static/peBanner.png" mode="widthFix"></image>
		</view>
		<u-card v-for="item in dataList" :title="item.reportDate" @click="doEdit(item)">
			<view slot="body">
				<view class="u-body-item u-flex u-border-bottom u-col-between u-p-t-0">
					<u-row>
						<u-col span="5">
							<view>
								<view style="display: inline-block;font-size: 15px;color: blue;">{{item.healthAnalysis}}</view>
							</view>
						</u-col>
					</u-row>
				</view>
			</view>
		</u-card>
		<!-- :label="item.reportDate" -->
		<u-popup v-model="show" mode="bottom">
			<view style="padding: 20px 20px;">
				<u-form :model="form" ref="uForm" label-width="90px">
					<u-form-item label="报告日期">
						<u-input v-model="form.reportDate" @click="openCalendar"></u-input>
					</u-form-item>
					<u-form-item label="报告内容">
						<u-input v-model="form.reportContent" ></u-input>
					</u-form-item>
					<u-form-item label="健康分析">
						<u-input v-model="form.healthAnalysis" ></u-input>
					</u-form-item>
					<u-form-item label="健康建议">
						<!-- 千卡路里 -->
						<u-input v-model="form.suggestion" ></u-input>
					</u-form-item>
				</u-form>
				<u-button @click="doSave" style="margin-top: 15px;" type="primary">保存</u-button>
			</view>
		</u-popup>
		<view class="box" v-if="mode === 'tab'">
			<view class="cu-bar tabbar bg-white shadow foot" style="bottom: 40px;">
				<view @click="doAdd" class="action text-gray add-action">
					<image class="logo_btn" mode="widthFix" src="../../../static/jiahao.png"></image>
					<view :class="PageCur=='dietManage'?'color_main':'text-gray'">体检提交</view>
				</view>
			</view>
		</view>
		<view class="box" v-else>
			<view class="cu-bar tabbar bg-white shadow foot">
				<view @click="doAdd" class="action text-gray add-action">
					<image class="logo_btn" mode="widthFix" src="../../../static/jiahao.png"></image>
					<view :class="PageCur=='dietManage'?'color_main':'text-gray'">体检提交</view>
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
					reportDate: '',
					reportContent: '',
					healthAnalysis: '',
					suggestion: ''
				},
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
					url: 'phyExamReport/list',
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
			doAdd() {
				this.form = {}
				this.show = true
			},
			openCalendar() {
				this.calendarSwitch = true
			},
			confirmDate(e) {
				console.log(e)
				this.form.reportDate = e.result
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
						url: 'phyExamReport/insert',
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
						url: 'phyExamReport/update',
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