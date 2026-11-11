const assetPathPrefix = "https://www.figma.com/api/mcp/asset/477badf9-e9de-4b69-9c69-129159eb8744";
const imgContainer = `${assetPathPrefix}/5f578.svg`;
const imgContainer1 = `${assetPathPrefix}/9812a.svg`;
const imgContainer2 = `${assetPathPrefix}/f1263.svg`;
const imgIconLock = `${assetPathPrefix}/614c6.svg`;
const imgIconBike = `${assetPathPrefix}/3492d.svg`;
const imgIconFlash = `${assetPathPrefix}/48a31.svg`;
const imgIconUp = `${assetPathPrefix}/ff299.svg`;
const imgIconCamera = `${assetPathPrefix}/40e12.svg`;

export default function CustomerNotification() {
  return (
    <div className="bg-[#fbf9f1] relative size-full" data-node-id="3:5861" data-name="Customer Notification">
      <div className="absolute bg-gradient-to-b content-stretch flex flex-col from-[#fbf9f1] h-[844px] items-start left-0 overflow-clip to-[#ffecb8] top-0 w-[390px]" data-node-id="136:3" data-name="Lock screen">
        <div className="content-stretch flex h-[24px] items-center justify-between px-[16px] relative shrink-0 w-full" data-node-id="136:4" data-name="Container">
          <div className="content-stretch flex flex-col items-start relative shrink-0" data-node-id="136:5" data-name="Container">
            <div className="[word-break:break-word] flex flex-col font-['Plus_Jakarta_Sans:SemiBold'] font-semibold justify-center leading-[0] relative shrink-0 text-[#18181f] text-[11px] tracking-[0.5px] whitespace-nowrap" data-node-id="136:6">
              <p className="leading-[16px]">9:41</p>
            </div>
          </div>
          <div className="content-stretch flex gap-[4px] items-center relative shrink-0" data-node-id="136:7" data-name="Container">
            <div className="relative shrink-0 size-[11.667px]" data-node-id="136:8" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer} />
            </div>
            <div className="h-[9.917px] relative shrink-0 w-[14px]" data-node-id="136:10" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer1} />
            </div>
            <div className="h-[11.667px] relative shrink-0 w-[5.833px]" data-node-id="136:12" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer2} />
            </div>
          </div>
        </div>
        <div className="content-stretch flex flex-col gap-[4px] items-center overflow-clip py-[24px] relative shrink-0 w-full" data-node-id="136:14" data-name="Clock">
          <div className="bg-white border border-[#ece8df] border-solid content-stretch flex gap-[6px] items-center overflow-clip px-[10px] py-[4px] relative rounded-[999px] shrink-0" data-node-id="136:15" data-name="Container">
            <div className="relative shrink-0 size-[12px]" data-node-id="136:16" data-name="icon/lock">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconLock} />
            </div>
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.4] relative shrink-0 text-[#6b6b73] text-[11px] whitespace-nowrap" data-node-id="136:19">
              Locked
            </p>
          </div>
          <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Light'] font-light leading-[1.4] min-w-full relative shrink-0 text-[#18181f] text-[72px] text-center w-[min-content]" data-node-id="136:20">
            9:41
          </p>
          <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Medium'] font-medium leading-[1.4] min-w-full relative shrink-0 text-[#6b6b73] text-[14px] text-center w-[min-content]" data-node-id="136:21">
            Wednesday, Oct 24 · 28°C
          </p>
        </div>
        <div className="content-stretch flex flex-col gap-[12px] items-start overflow-clip px-[16px] py-[8px] relative shrink-0 w-full" data-node-id="136:22" data-name="Notifications">
          <div className="[word-break:break-word] content-stretch flex items-center leading-[1.4] overflow-clip relative shrink-0 w-full" data-node-id="136:23" data-name="Container">
            <p className="flex-[1_0_0] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold min-w-px relative text-[#6b6b73] text-[13px]" data-node-id="136:24">
              Notifications
            </p>
            <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#a3a3ab] text-[12px] whitespace-nowrap" data-node-id="136:25">
              3 new
            </p>
          </div>
          <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-col gap-[8px] items-start overflow-clip p-[16px] relative rounded-[20px] shadow-[0px_4px_16px_0px_rgba(23,23,31,0.06)] shrink-0 w-full" data-node-id="136:26" data-name="Notification – Your rider is on the way">
            <div className="content-stretch flex gap-[8px] items-center overflow-clip relative shrink-0 w-full" data-node-id="136:27" data-name="Container">
              <div className="bg-[#febc20] content-stretch flex items-center justify-center overflow-clip relative rounded-[6px] shrink-0 size-[22px]" data-node-id="136:28" data-name="Container">
                <div className="relative shrink-0 size-[13px]" data-node-id="136:29" data-name="icon/bike">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconBike} />
                </div>
              </div>
              <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.4] relative shrink-0 text-[#6b6b73] text-[12px] whitespace-nowrap" data-node-id="136:34">
                Tagoloan Xpress
              </p>
              <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.4] min-w-px relative text-[#a3a3ab] text-[12px]" data-node-id="136:35">
                · 2m
              </p>
              <div className="bg-[#e6f5ec] content-stretch flex items-center overflow-clip px-[8px] py-[2px] relative rounded-[999px] shrink-0" data-node-id="136:36" data-name="Chip">
                <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.4] relative shrink-0 text-[#1e9e5a] text-[11px] whitespace-nowrap" data-node-id="136:37">
                  Active
                </p>
              </div>
            </div>
            <div className="[word-break:break-word] content-stretch flex flex-col gap-[2px] items-start leading-[1.4] overflow-clip relative shrink-0 w-full" data-node-id="136:38" data-name="Container">
              <p className="font-['Plus_Jakarta_Sans:SemiBold'] font-semibold relative shrink-0 text-[#18181f] text-[15px] w-full" data-node-id="136:39">
                Your rider is on the way
              </p>
              <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#6b6b73] text-[13px] w-full" data-node-id="136:40">
                Juan is heading to Minute Burger for your order.
              </p>
            </div>
            <div className="content-stretch cursor-pointer flex gap-[8px] items-start overflow-clip relative shrink-0 w-full" data-node-id="136:41" data-name="Container">
              <a className="bg-[#febc20] content-stretch flex flex-[1_0_0] items-center justify-center min-w-px overflow-clip px-[14px] py-[10px] relative rounded-[12px]" data-node-id="136:42" data-name="Action – Track order">
                <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.4] relative shrink-0 text-[#18181f] text-[13px] text-left whitespace-nowrap" data-node-id="136:43">
                  Track order
                </p>
              </a>
              <a className="bg-[#f3f1ea] content-stretch flex flex-[1_0_0] items-center justify-center min-w-px overflow-clip px-[14px] py-[10px] relative rounded-[12px]" data-node-id="136:45" data-name="Action – Log in">
                <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.4] relative shrink-0 text-[#18181f] text-[13px] text-left whitespace-nowrap" data-node-id="136:46">
                  Log in
                </p>
              </a>
            </div>
          </div>
          <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-col gap-[8px] items-start overflow-clip p-[16px] relative rounded-[20px] shadow-[0px_4px_16px_0px_rgba(23,23,31,0.06)] shrink-0 w-full" data-node-id="136:48" data-name="Notification – Rider accepted your request">
            <div className="content-stretch flex gap-[8px] items-center overflow-clip relative shrink-0 w-full" data-node-id="136:49" data-name="Container">
              <div className="bg-[#febc20] content-stretch flex items-center justify-center overflow-clip relative rounded-[6px] shrink-0 size-[22px]" data-node-id="136:50" data-name="Container">
                <div className="relative shrink-0 size-[13px]" data-node-id="136:51" data-name="icon/bike">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconBike} />
                </div>
              </div>
              <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.4] relative shrink-0 text-[#6b6b73] text-[12px] whitespace-nowrap" data-node-id="136:56">
                Tagoloan Xpress
              </p>
              <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.4] min-w-px relative text-[#a3a3ab] text-[12px]" data-node-id="136:57">
                · 15m
              </p>
            </div>
            <div className="[word-break:break-word] content-stretch flex flex-col gap-[2px] items-start leading-[1.4] overflow-clip relative shrink-0 w-full" data-node-id="136:58" data-name="Container">
              <p className="font-['Plus_Jakarta_Sans:SemiBold'] font-semibold relative shrink-0 text-[#18181f] text-[15px] w-full" data-node-id="136:59">
                Rider accepted your request
              </p>
              <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#6b6b73] text-[13px] w-full" data-node-id="136:60">
                Juan Dela Cruz accepted Pasugo #TGX-8921.
              </p>
            </div>
          </div>
          <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-col gap-[8px] items-start overflow-clip p-[16px] relative rounded-[20px] shadow-[0px_4px_16px_0px_rgba(23,23,31,0.06)] shrink-0 w-full" data-node-id="136:61" data-name="Notification – Delivery fee confirmed">
            <div className="content-stretch flex gap-[8px] items-center overflow-clip relative shrink-0 w-full" data-node-id="136:62" data-name="Container">
              <div className="bg-[#febc20] content-stretch flex items-center justify-center overflow-clip relative rounded-[6px] shrink-0 size-[22px]" data-node-id="136:63" data-name="Container">
                <div className="relative shrink-0 size-[13px]" data-node-id="136:64" data-name="icon/bike">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconBike} />
                </div>
              </div>
              <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.4] relative shrink-0 text-[#6b6b73] text-[12px] whitespace-nowrap" data-node-id="136:69">
                Tagoloan Xpress
              </p>
              <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.4] min-w-px relative text-[#a3a3ab] text-[12px]" data-node-id="136:70">
                · 1h
              </p>
            </div>
            <div className="[word-break:break-word] content-stretch flex flex-col gap-[2px] items-start leading-[1.4] overflow-clip relative shrink-0 w-full" data-node-id="136:71" data-name="Container">
              <p className="font-['Plus_Jakarta_Sans:SemiBold'] font-semibold relative shrink-0 text-[#18181f] text-[15px] w-full" data-node-id="136:72">
                Delivery fee confirmed
              </p>
              <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#6b6b73] text-[13px] w-full" data-node-id="136:73">
                Your fee is ₱60.00, based on GPS distance.
              </p>
            </div>
          </div>
        </div>
        <div className="flex-[1_0_0] min-h-px relative w-full" data-node-id="136:74" data-name="Flexible space" />
        <div className="content-stretch flex items-center overflow-clip px-[32px] py-[16px] relative shrink-0 w-full" data-node-id="136:75" data-name="Lock actions">
          <div className="bg-white border border-[#ece8df] border-solid content-stretch flex items-center justify-center overflow-clip relative rounded-[24px] shrink-0 size-[48px]" data-node-id="136:76" data-name="Container">
            <div className="relative shrink-0 size-[20px]" data-node-id="136:77" data-name="icon/flash">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconFlash} />
            </div>
          </div>
          <div className="content-stretch flex flex-[1_0_0] flex-col gap-[2px] items-center min-w-px overflow-clip relative" data-node-id="136:80" data-name="Container">
            <div className="relative shrink-0 size-[16px]" data-node-id="136:81" data-name="icon/up">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconUp} />
            </div>
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Medium'] font-medium leading-[1.4] relative shrink-0 text-[#6b6b73] text-[12px] whitespace-nowrap" data-node-id="136:83">
              Swipe up to unlock
            </p>
          </div>
          <div className="bg-white border border-[#ece8df] border-solid content-stretch flex items-center justify-center overflow-clip relative rounded-[24px] shrink-0 size-[48px]" data-node-id="136:84" data-name="Container">
            <div className="relative shrink-0 size-[20px]" data-node-id="136:85" data-name="icon/camera">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconCamera} />
            </div>
          </div>
        </div>
        <div className="content-stretch flex items-start justify-center overflow-clip py-[10px] relative shrink-0 w-full" data-node-id="136:88" data-name="Container">
          <div className="bg-[#18181f] h-[4px] relative rounded-[2px] shrink-0 w-[120px]" data-node-id="136:89" data-name="Rectangle" />
        </div>
      </div>
    </div>
  );
}
