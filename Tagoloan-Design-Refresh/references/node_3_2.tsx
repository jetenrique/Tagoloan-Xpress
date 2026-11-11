const assetPathPrefix = "https://www.figma.com/api/mcp/asset/f002cf18-54b6-483a-a85a-095fcee43a74";
const imgIosSignal = `${assetPathPrefix}/56616.svg`;
const imgIosWifiSignal = `${assetPathPrefix}/55d99.svg`;
const imgIosBatteryFull = `${assetPathPrefix}/8b209.svg`;
const imgTagoloanXpressLogo = `${assetPathPrefix}/626d7.svg`;
const imgLogoMarkRider = `${assetPathPrefix}/5fcb6.svg`;
const imgShoppingBag = `${assetPathPrefix}/bf5e3.svg`;
const imgScooter = `${assetPathPrefix}/09d3e.svg`;

export default function WelcomeEntryView() {
  return (
    <div className="bg-[#febc20] content-stretch flex flex-col items-start relative size-full" data-node-id="3:2" data-name="welcome-entry-view">
      <div className="content-stretch flex flex-col gap-[12px] h-[340px] items-center pb-[20px] relative shrink-0 w-full" data-node-id="3:3" data-name="top-header">
        <div className="content-stretch flex h-[40px] items-center justify-between px-[20px] relative shrink-0 w-full" data-node-id="3:4" data-name="status-bar">
          <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[normal] relative shrink-0 text-[#18181f] text-[14px] whitespace-nowrap" data-node-id="3:5">
            9:41
          </p>
          <div className="content-stretch flex gap-[6px] items-center relative shrink-0" data-node-id="3:6" data-name="Frame">
            <div className="relative shrink-0 size-[18px]" data-node-id="3:7" data-name="ios-signal">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIosSignal} />
            </div>
            <div className="relative shrink-0 size-[18px]" data-node-id="3:9" data-name="ios-wifi-signal">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIosWifiSignal} />
            </div>
            <div className="h-[18px] relative shrink-0 w-[26px]" data-node-id="3:11" data-name="ios-battery-full">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIosBatteryFull} />
            </div>
          </div>
        </div>
        <div className="content-stretch flex flex-col items-center relative shrink-0 w-full" data-node-id="3:13" data-name="logo-group">
          <div className="h-[126px] relative shrink-0 w-[270px]" data-node-id="151:2" data-name="Tagoloan Xpress logo">
            <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgTagoloanXpressLogo} />
          </div>
        </div>
        <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.3] relative shrink-0 text-[#18181f] text-[14px] text-center w-full" data-node-id="3:16">
          What do you need, and where should we get it?
        </p>
        <div className="content-stretch flex flex-col h-[100px] items-center justify-center relative shrink-0 w-full" data-node-id="3:17" data-name="rider-illustration">
          <div className="h-[90px] relative shrink-0 w-[120px]" data-node-id="91:2" data-name="logo-mark-rider">
            <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgLogoMarkRider} />
          </div>
        </div>
      </div>
      <div className="bg-white border-[#e9e5db] border-solid border-t content-stretch flex flex-[1_0_0] flex-col items-start justify-between min-h-px pb-[16px] pt-[28px] px-[24px] relative rounded-tl-[28px] rounded-tr-[28px] w-full" data-node-id="3:20" data-name="bottom-container">
        <div className="content-stretch flex flex-col gap-[20px] items-start relative shrink-0 w-full" data-node-id="3:21" data-name="selection-area">
          <div className="content-stretch flex flex-col gap-[4px] items-start relative shrink-0 w-full" data-node-id="3:22" data-name="Frame">
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Bold'] font-bold leading-[normal] min-w-full relative shrink-0 text-[#18181f] text-[18px] w-[min-content]" data-node-id="3:23">
              Welcome! Select your portal to continue:
            </p>
            <div className="bg-[#febc20] h-[4px] relative rounded-[2px] shrink-0 w-[40px]" data-node-id="3:24" data-name="Rectangle" />
          </div>
          <div className="content-stretch flex flex-col gap-[16px] items-start relative shrink-0 w-full" data-node-id="3:25" data-name="buttons-stack">
            <a className="bg-[#febc20] content-stretch cursor-pointer drop-shadow-[0px_4px_8px_rgba(23,23,31,0.06)] flex gap-[16px] h-[80px] items-center px-[18px] py-[12px] relative rounded-[16px] shrink-0 w-full" data-node-id="3:26" data-name="portal-btn-i-am-a-customer">
              <div className="bg-white border border-[#e9e5db] border-solid content-stretch flex flex-col items-center justify-center relative rounded-[10px] shrink-0 size-[44px]" data-node-id="3:27" data-name="icon-container">
                <div className="relative shrink-0 size-[24px]" data-node-id="3:28" data-name="shopping-bag">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgShoppingBag} />
                </div>
              </div>
              <div className="[word-break:break-word] content-stretch flex flex-[1_0_0] flex-col gap-[2px] items-start min-w-px relative text-[#18181f] text-left" data-node-id="3:30" data-name="text-group">
                <p className="font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[normal] relative shrink-0 text-[15px] w-full" data-node-id="3:31">
                  I am a Customer
                </p>
                <p className="font-['Plus_Jakarta_Sans:Medium'] font-medium leading-[1.2] overflow-hidden relative shrink-0 text-[12px] text-ellipsis w-full whitespace-nowrap" data-node-id="3:32">{`Request errands, groceries & deliveries`}</p>
              </div>
            </a>
            <div className="bg-white border border-[#e9e5db] border-solid content-stretch drop-shadow-[0px_4px_8px_rgba(23,23,31,0.06)] flex gap-[16px] h-[80px] items-center px-[18px] py-[12px] relative rounded-[16px] shrink-0 w-full" data-node-id="3:33" data-name="portal-btn-i-am-a-rider">
              <div className="bg-[rgba(254,188,32,0.13)] content-stretch flex flex-col items-center justify-center relative rounded-[10px] shrink-0 size-[44px]" data-node-id="3:34" data-name="icon-container">
                <div className="relative shrink-0 size-[24px]" data-node-id="3:35" data-name="scooter">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgScooter} />
                </div>
              </div>
              <a className="[word-break:break-word] content-stretch cursor-pointer flex flex-[1_0_0] flex-col gap-[2px] items-start min-w-px relative text-left" data-node-id="3:37" data-name="text-group">
                <p className="font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[normal] relative shrink-0 text-[#18181f] text-[15px] w-full" data-node-id="3:38">
                  I am a Rider
                </p>
                <p className="font-['Plus_Jakarta_Sans:Medium'] font-medium leading-[1.2] overflow-hidden relative shrink-0 text-[#6b6b73] text-[12px] text-ellipsis w-full whitespace-nowrap" data-node-id="3:39">{`Accept & deliver Pasugo requests`}</p>
              </a>
            </div>
          </div>
        </div>
        <div className="content-stretch flex flex-col gap-[16px] items-center relative shrink-0 w-full" data-node-id="3:40" data-name="footer-group">
          <div className="content-stretch flex items-center px-[16px] py-[8px] relative rounded-[8px] shrink-0" data-node-id="3:41" data-name="admin-trigger">
            <p className="[text-underline-position:from-font] [word-break:break-word] decoration-from-font decoration-solid font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[normal] relative shrink-0 text-[#18181f] text-[13px] underline whitespace-nowrap" data-node-id="3:42">
              Admin Portal Access
            </p>
          </div>
          <div className="content-stretch flex h-[24px] items-center justify-center relative shrink-0 w-full" data-node-id="3:43" data-name="android-nav-bar">
            <div className="bg-[#18181f] h-[4px] opacity-30 relative rounded-[2px] shrink-0 w-[120px]" data-node-id="3:44" data-name="nav-handle" />
          </div>
        </div>
      </div>
    </div>
  );
}
